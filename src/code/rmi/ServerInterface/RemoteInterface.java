package code.rmi.ServerInterface;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

import code.rmi.classes.AdminData;
import code.rmi.classes.BikeDetails;
import code.rmi.classes.BikeResult;
import code.rmi.classes.Clientloging;
import code.rmi.classes.OrderDetails;
import code.rmi.classes.Questions;
import code.rmi.classes.Sugestions;

public interface RemoteInterface extends Remote {
	//login
		public Boolean AdminLogin(String username,String password)throws Exception;
		public void add_client(Clientloging demo)throws Exception;
		//add data to DB
		public void add_data(AdminData bean) throws Exception;
		public void add_order(OrderDetails org)throws Exception;
		public void add_suge(Sugestions sug)throws Exception;   
		public String saveAnswer(ArrayList<String> answers) throws Exception;
		public String saveBikeDetails(ArrayList<String> bike) throws Exception;
		//show data from DB
		public ArrayList<BikeDetails> getData() throws Exception;
		public ArrayList<Clientloging> getuserData() throws Exception;
		public ArrayList<OrderDetails> getorderData() throws Exception;
		public ArrayList<Sugestions> getsugestionData() throws Exception;
		//Search data from DB
		String[] searchBikeDetails(String search) throws Exception;
		//update data
		public String updateBikeDetails(ArrayList<String> bi) throws Exception;
		//chart-external API
		public String getChart(ArrayList<String> labelNames,ArrayList<Integer> values,String heading, String chartType)throws Exception;
		public int getItemCount(String colnName, String iName) throws Exception;
		//final result show to user
		public BikeResult getResult(String name,String price,String Fuel,String warrenty)throws Exception;
}
