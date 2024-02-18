package com.practice.java.design.pattern;

public class BridgeDesignPattern {
	public static void main(String[] args) {
		Youtube y = new Youtube(new HDProcessor());
		y.playVideo("Naadamaya");
		
		Youtube y1 = new Youtube(new UHDProcessor());
		y1.playVideo("ninade");

		Netflix n = new Netflix(new UHDProcessor());
		n.playVideo("haayagi");
	}

}

abstract class Video {

	VideoProcessor processor;

	public Video(VideoProcessor processor) {
		this.processor = processor;
	}

	abstract void playVideo(String videoFileName);
}

class Youtube extends Video {

	public Youtube(VideoProcessor processor) {
		super(processor);
	}

	@Override
	public void playVideo(String videoFileName) {
		System.out.println("Playing youtube video");
		this.processor.processVideo(videoFileName);
	}

}

class Netflix extends Video {

	public Netflix(VideoProcessor processor) {
		super(processor);
	}

	@Override
	public void playVideo(String videoFileName) {
		System.out.println("Playing netflix video");
		this.processor.processVideo(videoFileName);
	}

}

interface VideoProcessor {
	void processVideo(String videoFileName);
}

class HDProcessor implements VideoProcessor {

	@Override
	public void processVideo(String videoFileName) {
		System.out.println("processing by HDProcessor....Playing " + videoFileName);
	}

}

class UHDProcessor implements VideoProcessor {

	@Override
	public void processVideo(String videoFileName) {
		System.out.println("processing  by UHDProcessor....Playing " + videoFileName);
	}
}
