// Archivo: GestorXML_DOM.java
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestorXML_DOM {

    /**
     * Método 1: Escribe una lista de productos en un archivo XML usando la API DOM.
     *
     * @param productos   La lista de productos a escribir.
     * @param rutaArchivo La ruta del archivo de salida.
     */
    public void escribirProductosEnXML(List<Producto> productos, String rutaArchivo) {
        try {
            // Estas son las líneas que indicaste para empezar
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // 1. Crear el elemento raíz <productos>
            Element elementoRaiz = doc.createElement("productos");
            doc.appendChild(elementoRaiz);

            // 2. Recorrer la lista y crear un <producto> por cada objeto
            for (Producto p : productos) {
                // Crear el elemento <producto>
                Element elementoProducto = doc.createElement("producto");
                elementoRaiz.appendChild(elementoProducto);

                // Crear y añadir el elemento <id>
                Element elementoId = doc.createElement("id");
                elementoId.appendChild(doc.createTextNode(String.valueOf(p.getId())));
                elementoProducto.appendChild(elementoId);

                // Crear y añadir el elemento <nombre>
                Element elementoNombre = doc.createElement("nombre");
                elementoNombre.appendChild(doc.createTextNode(p.getNombre()));
                elementoProducto.appendChild(elementoNombre);

                // Crear y añadir el elemento <precio>
                Element elementoPrecio = doc.createElement("precio");
                elementoPrecio.appendChild(doc.createTextNode(String.valueOf(p.getPrecio())));
                elementoProducto.appendChild(elementoPrecio);
            }

            // 3. Escribir el contenido del Document en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Para formatear el XML

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

            System.out.println("Archivo XML (DOM) generado exitosamente en: " + rutaArchivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método 2: Lee un archivo XML y devuelve una lista de productos usando la API DOM.
     *
     * @param rutaArchivo La ruta del archivo XML a leer.
     * @return Una lista con los productos leídos.
     */
    public List<Producto> leerProductosDeXML(String rutaArchivo) {
        List<Producto> listaProductos = new ArrayList<>();
        File archivoXML = new File(rutaArchivo);
        if (!archivoXML.exists()) {
            System.err.println("Error: El archivo de entrada no existe -> " + rutaArchivo);
            return listaProductos;
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(archivoXML);

            // Normaliza el documento XML (buena práctica)
            doc.getDocumentElement().normalize();

            // 1. Obtener la lista de todos los nodos <producto>
            NodeList nodosProducto = doc.getElementsByTagName("producto");

            // 2. Recorrer la lista de nodos
            for (int i = 0; i < nodosProducto.getLength(); i++) {
                Node nodo = nodosProducto.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    // 3. Extraer el contenido de cada etiqueta hija
                    int id = Integer.parseInt(elemento.getElementsByTagName("id").item(0).getTextContent());
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    double precio = Double.parseDouble(elemento.getElementsByTagName("precio").item(0).getTextContent());

                    // 4. Crear el objeto y añadirlo a la lista
                    listaProductos.add(new Producto(id, nombre, precio));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
}