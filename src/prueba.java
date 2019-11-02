import java.util.Scanner;

public class prueba {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = "1";
        
        do {
            int tamaño = 100;
            System.out.println("Digite la entrada en el formato #,#####...");
            number = scanner.next();
            String n = null;
            String[] numero = new String[tamaño];
            String[] input = new String[tamaño];
            int size = 0;
            
            
            //Verificamos si contiene la coma y si contiene numeros antes y despues
            try {
                if (number.contains(",")) {
                    numero = number.split(",");
                    n = numero[1];
                    input = n.split("");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Digite el numero en formato #,#####...");
            }
            
            
            //Verificamos si el texto de entrada es numerico
            if (numero.length > 0) {
                try {
                    if (isNumeric(numero[0])) {
                        size = Integer.parseInt(numero[0]);
                    }
                }catch (NumberFormatException e) {
                    System.out.println("El digito antes de la coma no es un numero");
                }
                
            }
            
            
            
            //Verificamos si size esta entre 0 y 10 y si los caracteres despues de la coma son numericos
            if (size < 0 || size > 10) {
                System.out.println("El numero antes de la coma debe estar entre 0 y 10");
            } else if (isNumeric(n) != true) {
                System.out.println("El numero despues de la coma no cumple con el formato");
            } else {
                PrintHorizontalLine(input, "", "14", "", size);
                PrintVerticalLine(input, "1237", "", "56", size);
                PrintHorizontalLine(input, "", "017", "", size);
                PrintVerticalLine(input, "134579", "", "2", size);
                PrintHorizontalLine(input, "", "147", "", size);
            }
            
        } while (!number.equals("0,0"));
        
        
    }
    
    static void PrintHorizontalLine(String[] input, String leftMatch, String middleMatch, String rightMatch, int scale) {
        for (int i = 1; i <= scale; i++) {
            for (String c : input) {
                PrintDigitLine(c, leftMatch, "", 1);
                PrintDigitLine(c, middleMatch, "-", scale);
                PrintDigitLine(c, rightMatch, "", 1);
            }
            System.out.print("\n");
            break;
        }
        
    }
    
    static void PrintVerticalLine(String[] input, String leftMatch, String middleMatch, String rightMatch, int scale) {
        for (int i = 1; i <= scale; i++) {
            for (String c : input) {
                PrintDigitLine(c, leftMatch, "|", 1);
                PrintDigitLine(c, middleMatch, " ", scale);
                PrintDigitLine(c, rightMatch, "|", 1);
            }
            System.out.print("\n");
        }
        
    }
    
    private static void PrintDigitLine(String digit, String match, String charToPrint, int n) {
        for (int i = 0; i < n; i++) {
            if (match.contains(digit) || match.equals("")) {
                System.out.print(" ");
            } else {
                System.out.print(charToPrint);
            }
        }
    }
    
    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
            //System.out.println("resultado = " + resultado);
        } catch (NumberFormatException excepcion) {
            resultado = false;
            //System.out.println("resultado = " + resultado);
        }
        
        return resultado;
    }
}

