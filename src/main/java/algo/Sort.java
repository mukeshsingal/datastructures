public class Sort{
     public static void main(String []args){
        int[] arr = {1,5,4,7,3,2};
        arr = bubbleSort(arr);
        
        System.out.println("Sorted Array is ");
         for(int i: arr) {
            System.out.print(i + " -> ");
         }
     }
     
     public static int[] bubbleSort(int[] array) {
         for(int i = 0; i < array.length; i++) {
             for(int j = 1; j < array.length - i; j++) {
                 if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                 }
             }
         }
         return array;
     }
}
