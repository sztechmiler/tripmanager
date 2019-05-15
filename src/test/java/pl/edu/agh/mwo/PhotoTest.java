package pl.edu.agh.mwo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhotoTest {

	@Test
	public void testConstructor() {
		Photo photo = new Photo();
		assertEquals("", photo.getComment());
	}
	@Test
	public void testConstructorWithComment() {
		Photo photo = new Photo("SomeNewComment");
		assertEquals("SomeNewComment", photo.getComment());
	}
	@Test
	public void testSetWithComment() {
		Photo photo = new Photo("SomeNewComment");
		photo.setComment("NewComment");
		assertEquals("NewComment", photo.getComment());
	}

}
