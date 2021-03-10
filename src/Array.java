import java.io.Serializable;

public class Array<T> implements Serializable {
    private static final int DEFAULT_LENGTH=16;
    private T[] array;
    private int length;
    public Array(){
        array = (T[])new Object[DEFAULT_LENGTH];
        length=0;
    }
    public Array(int n){
        array = (T[])new Object[n];
        length=0;
    }
    public Array(T[] array){
        this.array=array;
        length=array.length;
    }
    public int length(){
        return length;
    }
    public Array getArray(){
        return this;
    }
    public T getAnElement(int i) throws ArrayException{
        if(i<0 || i>=length)
            throw new ArrayException("index out of bound");
        return array[i];
    }
    public void add(T element){
        if(length==array.length){
            T[] newArray=(T[])new Object[length+DEFAULT_LENGTH];
            for(int i=0;i<length;i++)
                newArray[i]=array[i];
            array=newArray;
        }
        array[length++]=element;
    }

    public void add(int index, T element) throws ArrayException{
        if(index<0 || index>length) throw new ArrayException("index out of bound");
        if(length==array.length){
            T[] newArray=(T[])new Object[length+DEFAULT_LENGTH];
            for(int i=0;i<length;i++)
                newArray[i]=array[i];
            array=newArray;
        }
        for(int i=length;i>index;i--)
            array[i]=array[i-1];
        array[index]=element;
        length++;
    }

    public void remove(T element){
        T[] tmpArray = (T[])new Object[length];
        int index=0;
        for(int i=0;i<length;i++)
            if(!array[i].equals(element)){
                tmpArray[index++]=array[i];
            }
        length--;
    }

    public int[] findIndex(T element){
        int count=0;
        for(int i=0;i<length;i++)
            if(array[i].equals(element))
                count++;
        int indices[]= new int[count],indexCount=0;
        for(int i=0;i<length;i++)
            if(array[i].equals(element))
                indices[indexCount++]=i;
        return indices;
    }

    Array<T> subArray(int start, int end) throws ArrayException{
        if(start>=end || start<0 || end>length)
            throw new ArrayException("index out of bound");
        Array<T> subArr= new Array<T>(end-start-1);
        for(int i=start;i<end;i++)
            subArr.add(this.getAnElement(i));
        return subArr;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void merge(T[] a, T[] b, MyComparator<T> myComparator){
        int newLength = a.length+b.length;
        if(length<newLength)
            array=(T[]) new Object[newLength];
        length = newLength;
        int currentIndex=0,indexA=0,indexB=0;
        while(indexA<a.length && indexB<b.length){
            if(myComparator.compare(a[indexA],b[indexB])<0)
                array[currentIndex++]=a[indexA++];
            else
                array[currentIndex++]=b[indexB++];
        }
        while (indexA<a.length)
            array[currentIndex++]=a[indexA++];
        while (indexB<b.length)
            array[currentIndex++]=b[indexB++];
    }

}
