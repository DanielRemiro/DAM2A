package Archivos;

import Objetos.Alumno;
import Objetos.Matricula;
import Interfaces.AlumnoRepositorio;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Xml implements AlumnoRepositorio {

    private final Path ruta;

    public Xml(String rutaArchivo) {
        this.ruta = Paths.get(rutaArchivo);
    }

    @Override
    public List<Alumno> cargar() throws Exception {
        List<Alumno> lista = new ArrayList<>();
        if (!Files.exists(ruta)) return lista;

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(ruta.toFile());
        NodeList alumnos = doc.getElementsByTagName("alumno");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < alumnos.getLength(); i++) {
            Element e = (Element) alumnos.item(i);
            Alumno a = new Alumno(
                    e.getAttribute("id"),
                    e.getElementsByTagName("nombre").item(0).getTextContent(),
                    e.getElementsByTagName("email").item(0).getTextContent()
            );
            NodeList mats = e.getElementsByTagName("matricula");
            for (int j = 0; j < mats.getLength(); j++) {
                Element m = (Element) mats.item(j);
                Date fecha = sdf.parse(m.getAttribute("fecha"));
                double nota = Double.parseDouble(m.getAttribute("nota"));
                a.agregarMatricula(new Matricula(fecha, nota));
            }
            lista.add(a);
        }
        return lista;
    }

    @Override
    public void guardar(List<Alumno> alumnos) throws Exception {
        Files.createDirectories(ruta.getParent() == null ? Paths.get(".") : ruta.getParent());

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("alumnos");
        doc.appendChild(root);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Alumno a : alumnos) {
            Element eA = doc.createElement("alumno");
            eA.setAttribute("id", a.getId());

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(a.getNombre());
            eA.appendChild(nombre);

            Element email = doc.createElement("email");
            email.setTextContent(a.getEmail());
            eA.appendChild(email);

            for (Matricula m : a.getMatriculas()) {
                Element eM = doc.createElement("matricula");
                eM.setAttribute("fecha", sdf.format(m.getFecha()));
                eM.setAttribute("nota", String.valueOf(m.getNota()));
                eA.appendChild(eM);
            }
            root.appendChild(eA);
        }

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(ruta.toFile()));
    }

    @Override
    public String getRuta() { return ruta.toString(); }
}
