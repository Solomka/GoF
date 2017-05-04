package ua.training.gof.adapter;

public class AdapterExample {

	/*
	 * Convert the interface of a class into another interface clients expect.
	 * Adapter lets classes work together that couldn’t otherwise because of
	 * incompatible interfaces
	 */
	public static void main(String[] args) {
		// 1. by means of extension
		VectorGraphicsInterface i1 = new VectorAdapterFromRaster();
		i1.drawLine();
		i1.drawSquare();

		// 2. by means of composition
		VectorGraphicsInterface i2 = new VectorAdapterFromRaster1(new RasterGraphics());
		i2.drawLine();
		i2.drawSquare();

	}
}

/* user's expected interface */
interface VectorGraphicsInterface {
	void drawLine();

	void drawSquare();
}

/* real class interface */
class RasterGraphics {
	void drawRasterLine() {
		System.out.println("Draw Raster Line");
	}

	void drawRasterSquare() {
		System.out.println("Draw Raster Square");
	}
}

/* Adapter */

/**
 * 1. by means of extension
 * 
 * @author Solomka
 *
 */
class VectorAdapterFromRaster extends RasterGraphics
		/* extends from existing realization */ implements
		VectorGraphicsInterface /* implements user's expected interface */ {

	@Override
	public void drawLine() {
		drawRasterLine();

	}

	@Override
	public void drawSquare() {
		drawRasterSquare();
	}
}

/**
 * 2. by means of composition
 */

class VectorAdapterFromRaster1 implements VectorGraphicsInterface {

	RasterGraphics rasterGraphics;

	VectorAdapterFromRaster1(RasterGraphics rasterGraphics) {
		this.rasterGraphics = rasterGraphics;
	}

	@Override
	public void drawLine() {
		rasterGraphics.drawRasterLine();

	}

	@Override
	public void drawSquare() {
		rasterGraphics.drawRasterSquare();

	}

}
