package com.liuxuan.effejavademo;

/**
 * 当遇到多个构造器参数时需要用到构建器（Builder模式）
 * 他既能保证像重叠构造器模式（Class class = new Class（para1， para2，...） ）那样的安全性，
 * 也能保证像JavaBean（setter方法设置参数）那样的可读性
 * @author 山贝戊
 *
 */
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
		public static class Builder {
			private final int servingSize;
			private final int servings;
			
			private int calories = 0;
			private int fat = 0;
			private int sodium = 0;
			private int carbohydrate = 0;
			
			public Builder(int servingSize, int serving) {
				this.servingSize = servingSize;
				this.servings = serving;
			}
			
			public Builder calories (int val) {
				calories = val;
				return this;
			}
			
			public Builder fat (int val) {
				fat = val;
				return this;
			}
			
			public Builder sodium (int val) {
				sodium = val;
				return this;
			}
			
			public Builder carbohydrate (int val) {
				carbohydrate = val;
				return this;
			}
			
			public NutritionFacts build () {
				return new NutritionFacts(this);
			}
		}
	
	private NutritionFacts (Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).carbohydrate(27).build();
	}
}
