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
		boolean ans = implication(conjunction(P,Q),R);
		return ans;
	}
	
	public boolean q_imply_p() {
		boolean ans = implication(Q,P);
		return ans;
	}
	
	public boolean k_B() {
		boolean ans = conjunction(conjunction(p_and_q_imply_R(), q_imply_p()), Q);
		return ans;
	}
		
	private void get_all() {
		System.out.print(p_and_q_imply_R()+"      ");
		System.out.print(q_imply_p()+"      ");
		System.out.println(k_B());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] data_structure = {
				{true, true, true}, {true, true, false},
				{true, false, true}, {true, false, false},
				{false, true, true}, {false, true, false},
				{false, false, true}, {false, false, false}
		};
		
		for(int i=0; i<data_structure.length ; i++) {
			new KnowledgeBase(data_structure[i][0], data_structure[i][1], data_structure[i][2]);
		}
	}
	
}
