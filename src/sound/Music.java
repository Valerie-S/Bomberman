package sound;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Music extends Thread{

	/**
	 * @param args
	 */
	private boolean playStop;
	public void play() {

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(
					"shuaicongge.wav"));// �����Ƶ������
			AudioFormat baseFormat = ais.getFormat();// ָ�����������ض����ݰ���
//			System.out.println("baseFormat=" + baseFormat);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					baseFormat);
//			System.out.println("info=" + info);
			SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
			// �ӻ�Ƶ�����Դ������
//			System.out.println("line=" + line);
			line.open(baseFormat);// �򿪾���ָ����ʽ���У�������ʹ�л�����������ϵͳ��Դ����ÿɲ�����
			line.start();// ����������ִ������ I/O
			int BUFFER_SIZE = 4000 * 20;
			int intBytes = 0;
			byte[] audioData = new byte[BUFFER_SIZE];
			while (intBytes != -1) {
				if(!playStop){
				intBytes = ais.read(audioData, 0, BUFFER_SIZE);// ����Ƶ����ȡָ������������������ֽڣ����������������ֽ������С�
				if (intBytes >= 0) {
					@SuppressWarnings("unused")
					int outBytes = line.write(audioData, 0, intBytes);// ͨ����Դ�����н���Ƶ����д���Ƶ����
				}
				}
			}
		} catch (Exception e) {

		}
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		play();
	}
	public boolean isPlayStop() {
		return playStop;
	}
	public void setPlayStop(boolean playStop) {
		this.playStop = playStop;
	}
}