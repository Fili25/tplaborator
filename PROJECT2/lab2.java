import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

public class lab2 {
    
      public static String[][] getArrayFromFile(String filePath){
        Scanner scannMatrix = null;
        ArrayList<ArrayList> Matrix = new ArrayList<ArrayList>();
        //Чтение файла и запись в сканер
        try{
            scannMatrix = new Scanner(new File(filePath));
        }catch(FileNotFoundException e){
            System.out.println("ФАЙЛ НЕ НАЙДЕН");
        }
        //Запись данных из сканера в двумерный ArrayList
        while(scannMatrix.hasNextLine()){
            Scanner scanLine = new Scanner(scannMatrix.nextLine());
            ArrayList<String> line = new ArrayList<String>();
            while(scanLine.hasNext()){
                line.add(scanLine.next());
            }
            Matrix.add(line);
        }
        //Определение размера и инициализация массива
        int arrWidth = 11;
        int arrLength = 4;
        String [][] array = new String[arrWidth][arrLength];
        //Добавление заголовков таблицы
        array[0][0] = "Country"; array[0][1] = "Immigrants"; array[0][2] = "% world total"; array[0][3] = "% population";
        array[1][0] = "United States";array[2][0] = "Russia";array[3][0] = "Germany";array[4][0] = "Saudi Arabia";array[5][0] = "United Arab Emirates";
        array[6][0] = "United Kingdom";array[7][0] = "France";array[8][0] = "Canada";array[9][0] = "Australia";array[10][0] = "Spain";
        //Заполнение таблицы
        for(int y = 0; y < Matrix.size(); y++){
            for(int x = 0; x < Matrix.get(y).size(); x++){
                array[y+1][x+1] = (String)Matrix.get(y).get(x);
            }
        }
        return array;
        
    }
      
    public static void resh(String array[][]){
        //общее колличество иммигрантов
        long num = 0;
        for(int i = 1; i < 11; i++){
            num += Long.valueOf(array[i][1]);
        }
        System.out.println("Всего иммигрантов: " + num);
        
        //общий процент иммигрантов в мире
        float num2 = 0;
        for(int j = 1; j < 11; j++){
            num2 += Float.valueOf(array[j][2]);
        }
        System.out.println("Процент иммигрантов в мире: " + num2);
        
        //самый низкий и самый высокий процент иммигрантов в странах
        float max = 0;
        float min = 100;
        int indexmax = 0;
        int indexmin = 0;
        for(int k = 1; k < 11; k++){
            if(Float.valueOf(array[k][3]) > max){
                max = Float.valueOf(array[k][3]);
                indexmax = k;
            }
            if(Float.valueOf(array[k][3]) < min){
                min = Float.valueOf(array[k][3]);
                indexmin = k;
            }
        }
        
        System.out.println("Процент иммигрантов самый низкий " + array[indexmin][0]);
        System.out.println("Процент иммигрантов самый высокий " + array[indexmax][0]);
        
        //общая численность населения всех 10 стран
        float num4 = 0;
        BigDecimal num3 = new BigDecimal(0);
        BigDecimal num33 = new BigDecimal(0);
        for(int l = 1; l < 11; l++){
            num3  = num3.add(new BigDecimal((Float.valueOf(array[l][1])/Float.valueOf(array[l][3])) * 100));
            
        }
        System.out.println("Население всех стран " + num3);
    }
    
    public static void main(String[] args) {
       String filePath = "C://Users//mikha//Desktop//LABYTP//PROJECT2//INFO.txt";
        String[][] myArray = getArrayFromFile(filePath);
        for(String[] y: myArray){
            for(String x: y){
                System.out.printf("%20s",x);
            }
            System.out.println();
        }
        System.out.println();
        resh(myArray);
    }
}
