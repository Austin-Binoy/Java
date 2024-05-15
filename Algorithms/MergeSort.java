public class MergeSort{
    public static void main(String [] args){
        int [] array = {8, 2, 5, 3, 4, 7, 6, 1};
        
        mergeSort(array);

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]+" ");
        }
    }

    private static void mergeSort(int [] array){
        int length = array.length;
        if (length <= 1) return;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int [length - middle];

        int i = 0; // left array
        int j= 0; //right array

        for(; i < length; i++){
            if(i < middle){
                leftArray[i] = array[i];
            }else{
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }


    private static void merge(int[] leftArray, int[] rightArray, int[] array){

        int leftSize = array.length / 2;
        int rightsize = array.length - leftSize;
        int i = 0, l = 0, r =0; //indices

        //check conditions for merging
        while(l < leftSize && r < rightsize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightsize){
            array[i] = rightArray[r];
            i++;
            r++;
    }
    }
}