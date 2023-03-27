package creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Singleton obj = null;

	private Singleton() {
	}

	public static Singleton getSingleton() {
		if (obj == null)
			obj = new Singleton();
		return obj;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		// return super.clone();
		return getSingleton();
		// return this;
	}

	protected Object readResolve() {
		return obj;
	}
	public static Singleton readWriteFile() throws IOException, ClassNotFoundException {
		FileOutputStream file = new FileOutputStream("D:\\FilePath\\Singleton.txt");
		ObjectOutputStream out = new ObjectOutputStream(file);

		// Method for serialization of object
		out.writeObject(obj);

		out.close();
		file.close();
		
		FileInputStream fis = new FileInputStream("D:\\FilePath\\Singleton.txt"); 
        ObjectInputStream in = new ObjectInputStream(fis); 
          
        // Method for deserialization of object 
        Singleton obj2 = null;
        obj2 = (Singleton)in.readObject(); 
          
        in.close(); 
        file.close(); 
		return obj2;
	}

}
