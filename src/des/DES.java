
package des;

import java.util.Scanner;


public class DES {
static int []expansionPermulationTable={ 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 };
static char[][]s1={{'E','4','D','1','2','F','B','8','3','A','6','C','5','9','0','7'},{'0','F','7','4','E','2','D','1','A','6','C','B','9','5','3','8'},{'4','1','E','8','D','6','2','B','F','C','9','7','3','A','5','0'},{'F','C','8','2','4','9','1','7','5','B','3','E','A','0','6','D'}}; 
static char[][]s2={{'F','1','8','E','6','B','3','4','9','7','2','D','C','0','5','A'},{'3','D','4','7','F','2','8','E','C','0','1','A','6','9','B','5'},{'0','E','7','B','A','4','D','1','5','8','C','6','9','3','2','F'},{'D','8','A','1','3','F','4','2','B','6','7','C','0','5','E','9'}};
static char[][]s3={{'A','0','9','E','6','3','F','5','1','D','C','7','B','4','2','8'},{'D','7','0','9','3','4','6','A','2','8','5','E','C','B','F','1'},{'D','6','4','9','8','F','3','0','B','1','2','C','5','A','E','7'},{'1','A','D','0','6','9','8','7','4','F','E','3','B','5','2','C'}};
static char[][]s4={{'7','D','E','3','0','6','9','A','1','2','8','5','B','C','4','F'},{'D','8','B','5','6','F','0','3','4','7','2','C','1','A','E','9'},{'A','6','9','0','C','B','7','D','F','1','3','E','5','2','8','4'},{'3','F','0','6','A','1','D','8','9','4','5','B','C','7','2','E'}};
static char[][]s5={{'2','C','4','1','7','A','B','6','8','5','3','F','D','0','E','9'},{'E','B','2','C','4','7','D','1','5','0','F','A','3','9','8','6'},{'4','2','1','B','A','D','7','8','F','9','C','5','6','3','0','E'},{'B','8','C','7','1','E','2','D','6','F','0','9','A','4','5','3'}};
static char[][]s6={{'C','1','A','F','9','2','6','8','0','D','3','4','E','7','5','B'},{'A','F','4','2','7','C','9','5','6','1','D','E','0','B','3','8'},{'9','E','F','5','2','8','C','3','7','0','4','A','1','D','B','6'},{'4','3','2','C','9','5','F','A','B','E','1','7','6','0','8','D'}};
static char[][]s7={{'4','B','2','E','F','0','8','D','3','C','9','7','5','A','6','1'},{'D','0','B','7','4','9','1','A','E','3','5','C','2','F','8','6'},{'1','4','B','D','C','3','7','E','A','F','6','8','0','5','9','2'},{'6','B','D','8','1','4','A','7','9','5','0','F','E','2','3','C'}};
static char[][]s8={{'D','2','8','4','6','F','B','1','A','9','3','E','5','0','C','7'},{'1','F','D','8','A','3','7','4','C','5','6','B','0','E','9','2'},{'7','B','4','1','9','C','E','2','0','6','A','D','F','3','5','8'},{'2','1','E','7','4','A','8','D','F','C','9','0','3','5','6','B'}}; 
static int []straightPermulationTable={ 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 };
     
     public static String hexaToBinary(String hexa){
    String binary="";
        String formatedInput="";
        for(int i=0;i<hexa.length();i++){
            switch(hexa.charAt(i)){
                
            case '0':
            binary="0000";
            break;
            
            case '1':
            binary="0001";
            break;
            
            case '2':
            binary="0010";
            break;
            
            case '3':
            binary="0011";
            break;
            
            case '4':
            binary="0100";
            break;
            
            case '5':
            binary="0101";
            break;
            
            case '6':
            binary="0110";
            break;
            
            case '7':
            binary="0111";
            break;
            
            case '8':
            binary="1000";
            break;
            
            case '9':
            binary="1001";
            break;
            
            case 'A':
            binary="1010";
            break;
            
            case 'B':
            binary="1011";
            break;
            
            case 'C':
            binary="1100";
            break;
            
            case 'D':
            binary="1101";
            break;
            
            case 'E':
            binary="1110";
            break;
            
            case 'F':
            binary="1111";
            break;
            }
            formatedInput+=binary;
            
        }
        return formatedInput;
    
}

    public static String permulationTable(int[]expansionPermulationTable,String formatedInput){
        
        String output = "";
       
        for(int i=0;i<expansionPermulationTable.length;i++){
            output+=formatedInput.charAt(expansionPermulationTable[i]-1);
        }
        
        String hexaOutput="";
      
        
          for(int i=0;i<output.length();i=i+4){
              
           String tmp=output.substring(i, i+4);
               
           int decimal = Integer.parseInt(tmp, 2);
           hexaOutput = hexaOutput+ Integer.toHexString(decimal);
        
  }
        output=hexaOutput.toUpperCase();
        String result=hexaToBinary(output);
                 
    
return result;

    }
    
    public static String performXOR(String key,String permulationTableOutput){
        int res;
        String output = "";
      
        for (int i = 0; i < key.length(); i++) {
            int keyChar = (int) key.charAt(i);
            int permulationTableOutputChar = (int) permulationTableOutput.charAt(i);
            res = (int) (keyChar ^ permulationTableOutputChar);
            
            output += res;
        }
        
        return output;   //binaryformat
    }
    
    public static String performSBox(String formatedInput){
        
    int count=0;
        String[]sixBitsArray=new String[formatedInput.length()/6];
        for(int i=0;i<formatedInput.length();i=i+6){
            String sixBits=formatedInput.substring(i, i+6);
            if(count<formatedInput.length()/6){
                sixBitsArray[count]=sixBits;
                count++;
            }   
            
        }
       
        String col="";
        StringBuilder output=new StringBuilder();
        int r=0;
        int c=0;
        for(int i=0;i<sixBitsArray.length;i++){
            switch(i){
                case 0:
                    StringBuilder row=new StringBuilder();
                    
                    col=sixBitsArray[0].substring(1, 5);
                    row.append(sixBitsArray[0].charAt(0));
                    row.append(sixBitsArray[0].charAt(5));
                   
                     c=Integer.parseInt(col,2);  
                     r=Integer.parseInt(row.toString(),2);
                    output.append(s1[r][c]);
                    break;
                    
                    
                 case 1:
                    StringBuilder row1=new StringBuilder();
                    
                    col=sixBitsArray[1].substring(1, 5);
                    row1.append(sixBitsArray[1].charAt(0));
                    row1.append(sixBitsArray[1].charAt(5));
                   
                     c=Integer.parseInt(col,2);
                     r=Integer.parseInt( row1.toString(),2);
                    output.append(s2[r][c]);
                    break;
                    
                  case 2:
                    StringBuilder row2=new StringBuilder();
                    
                    col=sixBitsArray[2].substring(1, 5);
                    row2.append(sixBitsArray[2].charAt(0));
                    row2.append(sixBitsArray[2].charAt(5));
                   
                     c=Integer.parseInt(col,2);
                     r=Integer.parseInt( row2.toString(),2);
                    output.append(s3[r][c]);
                    break;
                    
                  case 3:
                    StringBuilder row3=new StringBuilder();
                    
                    col=sixBitsArray[3].substring(1, 5);
                    row3.append(sixBitsArray[3].charAt(0));
                    row3.append(sixBitsArray[3].charAt(5));
                   
                     c=Integer.parseInt(col,2);
                     r=Integer.parseInt( row3.toString(),2);
                    output.append(s4[r][c]);
                    break;
                    

                     case 4:
                    StringBuilder row4=new StringBuilder();
                    
                    col=sixBitsArray[4].substring(1, 5);
                    row4.append(sixBitsArray[4].charAt(0));
                    row4.append(sixBitsArray[4].charAt(5));
                   
                     c=Integer.parseInt(col,2);
                     r=Integer.parseInt( row4.toString(),2);
                    output.append(s5[r][c]);
                    break;
                    
                     case 5:
                    StringBuilder row5=new StringBuilder();
                    
                    col=sixBitsArray[5].substring(1, 5);
                    row5.append(sixBitsArray[5].charAt(0));
                    row5.append(sixBitsArray[5].charAt(5));
                   
                     c=Integer.parseInt(col,2);
                     r=Integer.parseInt( row5.toString(),2);
                    output.append(s6[r][c]);
                    break;
                    
                     case 6:
                   StringBuilder row6=new StringBuilder();
                    
                    col=sixBitsArray[6].substring(1, 5);
                    row6.append(sixBitsArray[6].charAt(0));
                    row6.append(sixBitsArray[6].charAt(5));
                   
                     c=Integer.parseInt(col,2);
                     r=Integer.parseInt( row6.toString(),2);
                    output.append(s7[r][c]);
                    break;
                    
                     case 7:
                    StringBuilder row8=new StringBuilder();
                    
                    col=sixBitsArray[7].substring(1, 5);
                    row8.append(sixBitsArray[7].charAt(0));
                    row8.append(sixBitsArray[7].charAt(5));
                   
                     c=Integer.parseInt(col,2);
                     r=Integer.parseInt( row8.toString(),2);
                    output.append(s8[r][c]);
                    break;
                    
            }
        }
        String res=output.toString();
        return res;
    }
    
        public static void finalPermulationTable(int[]straightPermulationTable,String result){
        String res=hexaToBinary(result);
        String output = "";
       
        for(int i=0;i<straightPermulationTable.length;i++){
            output+=res.charAt(straightPermulationTable[i]-1);
        }
        
        String hexaOutput="";
      
        
          for(int i=0;i<output.length();i=i+4){
              
           String tmp=output.substring(i, i+4);
               
           int decimal = Integer.parseInt(tmp, 2);
           hexaOutput = hexaOutput+ Integer.toHexString(decimal);
        
  }
        System.out.println(hexaOutput.toUpperCase());    
                 
    }




    public static void main(String[] args) {
        
        
        Scanner scan=new Scanner(System.in);
        
        String input=scan.next();
        String key=scan.next();
        
        
       String formatedInput=hexaToBinary(input);
       String formatedKey=hexaToBinary(key);
       
       String outputOfExpansionPermulationBox=permulationTable(expansionPermulationTable,formatedInput);
       String outputOfXOR=performXOR(formatedKey,outputOfExpansionPermulationBox);
       String outputOfSBox=performSBox(outputOfXOR);
      finalPermulationTable(straightPermulationTable,outputOfSBox);
        
       
    }
    
}
