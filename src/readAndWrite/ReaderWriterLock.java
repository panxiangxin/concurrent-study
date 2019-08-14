package readAndWrite;

/**
 * @author www72
 * Date 2019/8/14 10:55
 * @Description 读写锁
 */
public class ReaderWriterLock {
		private int readingReaders = 0;
		private int waitingReaders = 0;
		private int writingWriters = 0;
		private int waitingWriters = 0;
		private boolean preWriter = true;
		
		public ReaderWriterLock(){
			this(true);
		}
		public ReaderWriterLock(boolean preWriter){
			this.preWriter = preWriter;
		}
		
		public synchronized void readLock(){
			this.waitingReaders++;
			try {
				while (writingWriters > 0 || (preWriter && waitingWriters > 0)) {
					
					this.wait();
				}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					waitingReaders--;
				}
			
			readingReaders++;
		}
		public synchronized void readUnLock(){
			readingReaders--;
			this.notifyAll();
		}
		
		public synchronized void writeLock(){
			waitingWriters++;
			try {
				while (writingWriters > 0 || readingReaders > 0) {
					this.wait();
				}
			}catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					waitingWriters--;
				}
				writingWriters++;
			
		}
		public synchronized void writeUnLock(){
			writingWriters--;
			this.notifyAll();
		}
}
