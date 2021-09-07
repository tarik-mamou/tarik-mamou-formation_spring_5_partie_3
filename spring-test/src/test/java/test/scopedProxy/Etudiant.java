package test.scopedProxy;

public class Etudiant {

	private Cours cours;

	public Etudiant(Cours cours) {
		this.cours = cours;

	}

	@Override
	public String toString() {
		return "Etudiant [cours=" + cours + "]";
	}

}
