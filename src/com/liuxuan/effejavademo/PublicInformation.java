package com.liuxuan.effejavademo;

/**
 * �ù�����ֱ�ӱ�¶���������һ���õİ취������������ǲ��ɱ�ģ�����������Σ���ͻ�СһЩ��������ı����API�����޷��ı�������ı�ʾ��
 * ���򱻶�ȡ��ʱ������Ҳ�޷���ȡ�������ж������ǿ���ǿ��Լ���������������������ȷ����ÿ��ʵ������ʾһ����Ч��ʱ��
 * @author ɽ����
 *
 */
public final class PublicInformation {
	
	private static final int HOURS_PER_DAY = 24;
	private static final int MINITES_PER_HOURS = 60;
	
	public final int hour;
	public final int minute;
	
	public PublicInformation (int hour, int minute) {
		if (hour < 0 || hour >= HOURS_PER_DAY) {
			throw new IllegalAccessError("Hour: " + hour);
		}
		if (minute < 0 || minute >= MINITES_PER_HOURS) {
			throw new IllegalAccessError("min: " + minute);
		}
		this.hour = hour;
		this.minute = minute;
	}
}
