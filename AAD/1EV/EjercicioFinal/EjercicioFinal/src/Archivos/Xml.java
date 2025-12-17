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
    // Ruta del archivo XML donde se guardarán o cargarán los alumnos

    public Xml(String rutaArchivo) {
        this.ruta = Paths.get(rutaArchivo);
        // Constructor que recibe la ruta del archivo y la convierte a Path
    }

    @Override
    public List<Alumno> cargar() throws Exception {
        List<Alumno> lista = new ArrayList<>();
        if (!Files.exists(ruta)) return lista;
        // Si el archivo no existe, devuelve una lista vacía

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(ruta.toFile());
        NodeList alumnos = doc.getElementsByTagName("alumno");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Prepara el parseador XML y un formateador de fechas

        for (int i = 0; i < alumnos.getLength(); i++) {
            Element e = (Element) alumnos.item(i);
            Alumno a = new Alumno(
                    e.getAttribute("id"),
                    e.getElementsByTagName("nombre").item(0).getTextContent(),
                    e.getElementsByTagName("email").item(0).getTextContent()
            );
            // Crea un Alumno con los datos de cada elemento <alumno>

            NodeList mats = e.getElementsByTagName("matricula");
            for (int j = 0; j < mats.getLength(); j++) {
                Element m = (Element) mats.item(j);
                Date fecha = sdf.parse(m.getAttribute("fecha"));
                double nota = Double.parseDouble(m.getAttribute("nota"));
                a.agregarMatricula(new Matricula(fecha, nota));
            }
            // Recorre todas las <matricula> de este alumno y las añade

            lista.add(a);
        }
        return lista;
        // Devuelve la lista completa de alumnos con sus matrículas
    }

    @Override
    public void guardar(List<Alumno> alumnos) throws Exception {
        Files.createDirectories(ruta.getParent() == null ? Paths.get(".") : ruta.getParent());
        // Asegura que la carpeta donde se guardará el XML exista

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("alumnos");
        doc.appendChild(root);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Crea un nuevo documento XML con raíz <alumnos>

        for (Alumno a : alumnos) {
            Element eA = doc.createElement("alumno");
            eA.setAttribute("id", a.getId());

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(a.getNombre());
            eA.appendChild(nombre);

            Element email = doc.createElement("email");
            email.setTextContent(a.getEmail());
            eA.appendChild(email);
            // Crea el elemento <alumno> con sus datos básicos

            for (Matricula m : a.getMatriculas()) {
                Element eM = doc.createElement("matricula");
                eM.setAttribute("fecha", sdf.format(m.getFecha()));
                eM.setAttribute("nota", String.valueOf(m.getNota()));
                eA.appendChild(eM);
            }
            // Añade todas las matrículas de este alumno como elementos <matricula>

            root.appendChild(eA);
        }

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(ruta.toFile()));
        // Transforma el documento en XML y lo escribe en el archivo indicado
    }

    @Override
    public String getRuta() { return ruta.toString(); }
    // Devuelve la ruta del archivo XML
}
