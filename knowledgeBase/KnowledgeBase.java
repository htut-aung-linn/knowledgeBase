package knowledgeBase;

public class KnowledgeBase {
	public boolean P;
	public boolean Q;
	public boolean R;
	
	public KnowledgeBase(boolean Pv, boolean Qv, boolean Rv) {
		P = Pv; Q = Qv; R = Rv;
		get_all();
	}
	
	private boolean conjunction(boolean A, boolean B) {
		return A && B;
	}

	private boolean implication(boolean A, boolean B) {
		return (!A) || B; 
	}
	
	public boolean p_and_q_imply_R() {
		return implication(conjunction(P,Q),R);
	}
	
	public boolean q_imply_p() {
		return implication(Q,P);
	}
	
	public boolean k_B() {
		return conjunction(conjunction(p_and_q_imply_R(), q_imply_p()), Q);
	}
	
	public boolean K_B_imply_R() {
		return implication(k_B(), R);
	}
		
	private void get_all() {
		System.out.print(P+"      ");
		System.out.print(Q+"      ");
		System.out.print(R+"      ");
		System.out.print(p_and_q_imply_R()+"      ");
		System.out.print(q_imply_p()+"      ");
		System.out.print(k_B()+"      ");
		System.out.println(K_B_imply_R());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] data_structure = {
				{true, true, true}, {true, true, false},
				{true, false, true}, {true, false, false},
				{false, true, true}, {false, true, false},
				{false, false, true}, {false, false, false}
		};
		
		System.out.println("P          Q          R      (p^Q)=>R    Q=>P      KB        KB=>R");
		for(int i=0; i<data_structure.length ; i++) {
			new KnowledgeBase(data_structure[i][0], data_structure[i][1], data_structure[i][2]);
		}
	}
	
}
