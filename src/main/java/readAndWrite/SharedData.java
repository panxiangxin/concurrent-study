package readAndWrite;

import java.util.Random;

/**
 * @author www72
 * Date 2019/8/14 11:09
 * @Description
 */
public class SharedData {
	private final char[] buffer;
	private final ReaderWriterLock lock = new ReaderWriterLock();
	public SharedData(int size) {
		this.buffer = new char[size];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = '*';
		}
	}
	public char[] read(){
		try{
		lock.readLock();
		return doRead();
		}finally {
			lock.readUnLock();
		}
	}
	public void write(char c){
		try{
			lock.writeLock();
			doWrite(c);
		}finally {
			lock.writeUnLock();
		}
	}
	
	private void doWrite(char c) {
		for (int i=0 ;i<buffer.length;i++){
			buffer[i] = c;
		}
		slowly(10);
	}
	
	private char[] doRead() {
		char[] newBuf = new char[buffer.length];
		for (int i = 0; i < buffer.length; i++) {
			newBuf[i] = buffer[i];
		}
		slowly(50);
		return newBuf;
	}
	
	private void slowly(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
