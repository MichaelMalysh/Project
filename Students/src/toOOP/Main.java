package toOOP;



public class Main {

	public static void main(String[] args) {
	
		ConnectionToSQL connectToSQL = new ConnectionToSQL();
		
		connectToSQL.connect();
		System.out.println();
		connectToSQL.statement();
		//connectToSQL.resultSet(2);
		System.out.println();
		//connectToSQL.resultSet("Speciality");
		//System.out.println(connectToSQL.preparedStatement("dsfgsd", "hfgh", 1, "�fsd"));
		connectToSQL.preparedStatement("�������� ������������� ��������� � ��������", "��������� ����� �� ����������� �������㳿", 3, "�����");
		
		
		
		
	}
}
