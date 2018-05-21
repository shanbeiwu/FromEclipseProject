package com.liuxuan.effejavademo;

/**
 * 让公有类直接暴露域从来不是一个好的办法，但是如果域是不可变的，这种做法的危害就会小一些，如果不改变类的API，就无法改变这种类的表示法
 * 当域被读取的时候，我们也无法采取辅助的行动，但是可以强加约束条件，例如下面这个类确保了每个实例都表示一个有效的时间
 * @author 山贝戊
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
