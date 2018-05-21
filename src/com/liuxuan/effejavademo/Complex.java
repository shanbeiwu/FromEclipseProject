package com.liuxuan.effejavademo;

import javax.print.attribute.HashDocAttributeSet;

/**
 * ������ʾһ�����������˱�׼��object����֮�⣬�����ṩ�����ʵ�����鲿�ķ��ʷ������Լ�4�ֻ����������㷨
 * ע������Щ�����㷨����δ����������µ�Complexʵ�����������޸����ʵ������������ɱ��඼ʹ����������ģʽ
 * ������Ϊ��������������Ϊ��Щ����������һ�������������Щ�����Բ�������������������޸���
 * @author ɽ����
 *
 */
public class Complex {
	private final double re;
	private final double em;
	
	public Complex(double re, double em) {
		this.re = re;
		this.em = em;
	}
	
	public double realPart() {//�ṩ����ʵ���ķ���
		return re;
	}
	
	public double imaginaryPart() {//�ṩ�����鲿�ķ���
		return em;
	} 
	
	public Complex add(Complex c) {
		return new Complex(re + c.re, em + c.em);
	}
	
	public Complex subtract(Complex c) {
		return new Complex(re - c.re, em - c.em);
	}
	
	public Complex multiply(Complex c) {
		return new Complex(re * c.re + em * c.em, 
							re * c.re - em * c.re);
	}
	
	public Complex divide(Complex c) {
		double tmp = c.re * c.re + c.em * c.em;
		return new Complex((re * c.re + em * c.em) / tmp, 
							(em * c.re - re * c.em) /tmp);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;
		return Double.compare(re, c.re) == 0 && Double.compare(em, c.em) ==0;
	}
	
	@Override
	public int hashCode() {
		int result = 17 + hashDouble(re);
		result = 31 * result + hashDouble(em);
		return result;
	}

	private int hashDouble(double val) {
		long longBits = Double.doubleToLongBits(re);
		return (int) (longBits ^ (longBits >>> 32));
	}
	
	@Override
	public String toString() {
		return "(" + re + " + " + em + "i)";
	}
}
