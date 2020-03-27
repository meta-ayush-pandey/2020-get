package collegecounceling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;


public class CollegeCounseling {

    FormulaEvaluator formulaEvaluator;
    FormulaEvaluator formulaEvaluator1;
    
    Map<String, Integer> collegeProgram = new HashMap<String, Integer>();
    HSSFSheet studentProgram ;
    HSSFSheet studentProgram1 ;
    Map<String, Queue> selectStudentsByParticularProgram = new  HashMap<String, Queue>();
    
    CollegeCounseling() throws IOException{
        FileInputStream fis = new FileInputStream(
                new File(
                        "C:\\Users\\Gaurav\\Desktop\\workspace\\DSA__Assignment2\\src\\Student.xls"));
        FileInputStream fis1 = new FileInputStream(
                new File(
                        "C:\\Users\\Gaurav\\Desktop\\workspace\\DSA__Assignment2\\src\\College.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        this.studentProgram = sheet;
        formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        for (Row row : sheet)
        {
            for (Cell cell : row) 
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(String.format("%-15s",
                            cell.getNumericCellValue()));
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(String.format("%-15s",
                            cell.getStringCellValue()));
                    break;
                }
            }
            System.out.println();
        }
        wb.close();
        
        HSSFWorkbook wb1 = new HSSFWorkbook(fis1);
        HSSFSheet sheet1 = wb1.getSheetAt(0);
        this.studentProgram1 = sheet1;
        formulaEvaluator1 = wb1.getCreationHelper().createFormulaEvaluator();
        String collegeProgramName = "";
        boolean skipFirstRow = true;
        
        for (Row row : sheet1) 
        {
            if(skipFirstRow){
                skipFirstRow = false;
                continue;
            }
            for (Cell cell : row)
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(String.format("%-15s",
                            cell.getNumericCellValue()));
                    collegeProgram.put(collegeProgramName,(int) Double.parseDouble(cell.toString()));
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(String.format("%-15s",
                            cell.getStringCellValue()));
                    collegeProgramName = cell.toString();
                    collegeProgram.put(collegeProgramName, -1);
                    break;
                }
            }
            System.out.println();
        }
        wb1.close();
        
        for (HashMap.Entry<String, Integer> entry : collegeProgram.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        
    }

    public void genrateQueue() {
        int count = 0;
        String name = "";
        boolean nameFlag;
        String cellValue;

        for (HashMap.Entry<String, Integer> entry : collegeProgram.entrySet()) {
            selectStudentsByParticularProgram.put(entry.getKey(), new Queue(
                    entry.getValue()));
        }
        for (Row row : studentProgram) {
            nameFlag = true;
            for (Cell cell : row)
            {
                if (formulaEvaluator.evaluateInCell(cell).getCellType() == Cell.CELL_TYPE_STRING) {
                    cellValue = cell.getStringCellValue();
                    if (nameFlag) {
                        name = cellValue;
                        nameFlag = false;
                    } else {
                        if (selectStudentsByParticularProgram.containsKey(cellValue)) {
                            if (selectStudentsByParticularProgram.get(cellValue).isFull()) {
                                continue;
                            } else {
                                selectStudentsByParticularProgram.get(cellValue).add(name);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    void show(){
        for (HashMap.Entry<String, Queue> entry : selectStudentsByParticularProgram.entrySet()) {
            System.out.print(entry.getKey()+" : ");
            entry.getValue().show();
        }
    }
    
    void saveData() throws FileNotFoundException, IOException{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("SelectedStudents");
        Cell cell;
        Row row ;
        int rowCount = 0, colCount = 0;

        row = sheet.createRow(rowCount);
        cell = row.createCell(colCount);
        cell.setCellValue((String) "Name");
        cell = row.createCell(colCount+1);
        cell.setCellValue((String) "Program");
        rowCount++;
        
        for (HashMap.Entry<String, Queue> entry : selectStudentsByParticularProgram.entrySet()) {
            for(String name: entry.getValue().getQueue()){
                row = sheet.createRow(rowCount);
                cell = row.createCell(colCount);
                cell.setCellValue((String) name);
                cell = row.createCell(colCount+1);
                cell.setCellValue(entry.getKey());
                rowCount++;
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream("SelectedStudents.xls")) {
            workbook.write(outputStream);
        }
    }
}