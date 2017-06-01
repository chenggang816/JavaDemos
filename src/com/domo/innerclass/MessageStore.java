package com.domo.innerclass;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageStore {
	final int maxBBSize = Integer.MAX_VALUE - 7;	//max ByteBuffer Size
	final int maxLBSize = maxBBSize / 8;			//max LongBuffer Size
	private static final MessageStore INSTANCE = new MessageStore();
	public MessageStore() {	
		
	}
	public static MessageStore getInstance() {
		return INSTANCE;
	}


	
	private String storePath;
	private File fileTopicOrQueue;	//store topics and queues and corresponding number

	private List<String> listHeaderKV = new ArrayList<>(120);
	private List<String> listHeaderK = new ArrayList<>(120);
	private List<String> listHeaderV = new ArrayList<>(120);

	
	File dir;
	public static long sendNum = 0;

	public String getStorePath() {
		return storePath;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath;
		dir = new File(storePath);
		if(fileTopicOrQueue != null) return;
		fileTopicOrQueue = new File(dir,"topicOrQueue.dat");
	}
	
	public class MsgPutter{
		//variables for put method 3
//		Map<String,LinkedBlockingQueue<ByteBuffer>> mapBuckEmptyBusQueue =  new HashMap<String,LinkedBlockingQueue<ByteBuffer>>();
//		Map<String,LinkedBlockingQueue<ByteBuffer>> mapBuckFullBusQueue =  new HashMap<String,LinkedBlockingQueue<ByteBuffer>>();
//		Map<String, ByteBuffer> mapBuckCurBuff = new HashMap<>();
//		Map<String, FileChannel> mapBuckFC = new HashMap<String, FileChannel>();
//		List<Thread> listThread = new ArrayList<Thread>(100);
//		BlockingQueue<ByteBuffer> queuePre =  new  LinkedBlockingQueue<ByteBuffer>();
//		{
//			long start = System.currentTimeMillis();
//			for(int i = 0; i < 1000; i++){
//				if(!queuePre.offer(ByteBuffer.allocateDirect(UNIT))){
//					break;
//				}
//			}
//			long end = System.currentTimeMillis();
//			System.out.println(end - start);
//		}
		//put method3
//		@SuppressWarnings("resource")
//		public void putMethod3(String headerKey, String headerValue, Message message) throws IOException{
//			DefaultBytesMessage byteMessage = (DefaultBytesMessage)message;
//			byte[] msgByteArray = byteMessage.serialize();
//			String bucket = headerValue;
//			LinkedBlockingQueue<ByteBuffer> emptyBusQueue,fullBusQueue;
//			synchronized(this){
//				if((emptyBusQueue = mapBuckEmptyBusQueue.get(bucket)) == null){
//					emptyBusQueue = new LinkedBlockingQueue<ByteBuffer>();
//					mapBuckEmptyBusQueue.put(bucket, emptyBusQueue);
//					fullBusQueue = new LinkedBlockingQueue<ByteBuffer>();
//					mapBuckFullBusQueue.put(bucket, fullBusQueue);
//					//get listHeaderKV
//					String kv = headerKey + "," + headerValue;
//					if(!listHeaderKV.contains(kv)){
//						listHeaderKV.add(kv);
//						Files.write(Paths.get(fileTopicOrQueue.getAbsolutePath()), listHeaderKV, Charset.forName("UTF-8"));
//					}
//					Integer num = listHeaderKV.indexOf(kv);	//get num
//					mapBuckFC.put(bucket, new RandomAccessFile(new File(dir,num.toString()), "rw").getChannel());
//					Thread t = new Thread(){
//						@Override
//						public void run(){
//							LinkedBlockingQueue<ByteBuffer> fullBusQueue = mapBuckFullBusQueue.get(bucket),
//									emptyBusQueue = mapBuckEmptyBusQueue.get(bucket);
//							FileChannel fc = mapBuckFC.get(bucket);
//							try {
//								while(true){
//									ByteBuffer buff = fullBusQueue.take();
//									buff.flip();
//									fc.write(buff);
//									buff.clear();
//									emptyBusQueue.put(buff);
//								}
//							} catch (InterruptedException | IOException e) {
//								e.printStackTrace();
//							}
//						}
//					};
//					t.start();
//				}
//				fullBusQueue = mapBuckFullBusQueue.get(bucket);
//				ByteBuffer buff = mapBuckCurBuff.get(bucket);
//				try {
//					//				System.out.printf("empty bus:%d\tfull bus:%d\n",emptyBusQueue.size(),fullBusQueue.size());
//					if(buff == null){
//						if(emptyBusQueue.isEmpty()){
//							if(fullBusQueue.size() <= 2){ 
//								for(int i = 0; i < 2; i++){
//									emptyBusQueue.put(queuePre.peek() == null?ByteBuffer.allocateDirect(UNIT):queuePre.poll());
//								}
//							}
//						}
//						buff = emptyBusQueue.take();
//						mapBuckCurBuff.put(bucket, buff);
//					}
//					if(buff.remaining() < 4){
//						fullBusQueue.put(buff);
//						buff = emptyBusQueue.take();
//						mapBuckCurBuff.put(bucket, buff);
//					}
//
//					byte b;
//					int positiveInt = msgByteArray.length;
//					positiveInt <<= 4;
//					boolean begin = false;
//					for(int i=1;i<=3;i++){
//						b = (byte)((positiveInt>>(32 - 7 * i))&0x7F);
//						if(b > 0 || begin){
//							buff.put((byte)(-b-1));
//							begin = true;
//						}
//					}
//					buff.put((byte)(positiveInt<<21>>>25));
//
//					if(msgByteArray.length <= buff.remaining()){
//						buff.put(msgByteArray);
//					}else{
//						int len = buff.remaining();
//						buff.put(msgByteArray,0,len);
//						fullBusQueue.put(buff);
//						buff = emptyBusQueue.take();
//						buff.put(msgByteArray,len,msgByteArray.length - len);
//						mapBuckCurBuff.put(bucket, buff);
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			sendNumIncrease();
//		}

//		public synchronized void sendNumIncrease(){
//			sendNum++;
//		}
	}
	private MessageStore.MsgPutter putter = this.new MsgPutter();
	/**
	 * one bucket represent one topic or queue
	 */
	public void putMessage(String headerKey, String headerValue) {
		try {
//			putter.putMethod3(headerKey,headerValue,message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	


	private Map<String, HashMap<String, LinkedBlockingQueue<byte[]>>> mapQueBuckQue = new HashMap<>();
	public static long cost = 0;
	private synchronized void fillListHeaderKVs() throws IOException{
		if(listHeaderKV.size() <= 0){
			listHeaderKV = Files.readAllLines(Paths.get(fileTopicOrQueue.getAbsolutePath()),Charset.forName("UTF-8"));
			for(String kv:listHeaderKV){
				String[] header = kv.split(",",2);
				listHeaderK.add(header[0]);
				listHeaderV.add(header[1]);
			}
		}
	}

	/**
	 * @throws IOException
	 */
	private ArrayList<ByteBuffer> getBufferList(FileChannel fc) throws IOException {
		ArrayList<ByteBuffer> buffList = new ArrayList<ByteBuffer>();
		int i = 0;
		for(; i < fc.size() / maxBBSize;i++){
			buffList.add(fc.map(MapMode.READ_ONLY, (long)i * maxBBSize, maxBBSize));
		}
		buffList.add(fc.map(MapMode.READ_ONLY, (long)i * maxBBSize, fc.size() % maxBBSize));
		return buffList;
	}
	
	public static void main(String args[]){
		INSTANCE.putMessage("a", "b");
	}
}
