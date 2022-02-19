public class Tiro {
	
	private int valor;
	
	public Tiro() {
		this.Lanzar();
	}
	
	public void Lanzar() {
		valor = (int) (Math.random() * 6 + 1);
		return;
	}
	public int getValor() {
		return valor;
	}
	public static void main(String[] ar)  {
		Tiro d1 = new Tiro();
		System.out.println(d1.getValor());
	}
}