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
	
	static boolean[][] generate_combination(){
		boolean[][] data_structure  = new boolean[8][3];
		int i = 0;
		while(i < 8) {
			if(i % 2 ==0) {
				data_structure[i][2] = true;
			}
			if((i>=0 && i<2) || (i>=4 && i<6 ) ) {
				data_structure[i][1] = true;
			}
			if(i > 3) {
				data_structure[i][0] = false;
			} else {
				data_structure[i][0] = true;
			}
			i++;
		}
		return data_structure;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dynamically produce the combination
		boolean[][] data_structure  = generate_combination();
		System.out.println("P          Q          R      (p^Q)=>R    Q=>P      KB        KB=>R");
		for(int i=0; i<data_structure.length ; i++) {
			new KnowledgeBase(data_structure[i][0], data_structure[i][1], data_structure[i][2]);
		}
	}
	
}
