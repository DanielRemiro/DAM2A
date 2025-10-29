import java.io.IOException;

public class main {

    public static void main(String[] args) {

        try {
            String[]infoProceso={"notepad.exe","notas.txt"};
            Process proceso=Runtime.getRuntime().exec(infoProceso);
            int codigoRetorno=proceso.waitFor();
            System.out.println("El codigo de retorno es: "+codigoRetorno);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
