import java.util.*;
public class KeywordList {
	
	
	private LinkedList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new LinkedList<Keyword>();
		
	}
	public void add(Keyword keyword){
		//7. add keyword to proper index base on its count
		for(int x=0; x<lst.size();x++) {
			if(lst.get(x).count>=keyword.count) {
				lst.add(x,keyword);
				break;
			}
		}
		for(int x=0; x<lst.size();x++) {
			if(lst.get(x).count<keyword.count) {
				lst.add(keyword);
			}
		}
		if(lst.isEmpty()) {
			lst.add(keyword);
		}
    }
	public void outputIndex(int i){
		if(i>lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		
		LinkedList<Keyword> results = new LinkedList<>();
		Keyword k = lst.get(i);		    
		results.add(k);		    		
		
		printKeywordList(results);
		}
		
	public void outputCount(int c){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.count == c){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
		}
	
	public void outputHas(String pattern){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.contains(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
		}
	
	public void outputName(String pattern){
		
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.equals(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
		}
	
	public void outputFirstN(int n){
		if(n>lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
		    Keyword k = lst.get(i);
		    if(i>0){
		    	sb.append(" ");
		    }
		    sb.append(k.toString());   
		}
		System.out.println(sb.toString());
		
		}
	
	public void outputScore(){
		float results = 0;
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    results += k.weight * k.count;
		}
		
		System.out.println(results);
		}
	
	public void deleteIndex(int i){
		
		if(i>=lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
			
		lst.remove(i);
		
		System.out.println("Done");
		}

	public void deleteCount(int c){
		// 8. remove nodes that the count is equal to cnt
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0; i<lst.size(); i++) {
			Keyword k = lst.get(i);
			if(k.count==c) {
				lst.remove(i);
				results.add(k);
			}
		}
		if(results.isEmpty()) {
			System.out.println("Not Found");
		}
		else {
			System.out.println("Done");
		}
    }
	public void deleteHas(String pattern){
		// 9. remove nodes that the name contains input name
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.contains(pattern)){
		    	lst.remove(i);
		    	results.add(k);
		    }
		}
		if(results.isEmpty()) {
			System.out.println("Not Found");
		}
		else {
			System.out.println("Done");
		}
    }
	
	
	public void deleteName(String name){
		// 10. remove nodes that the name is equal to input name
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    if(k.name.equals(name)){
		    	lst.remove(i);
		    	results.add(k);
		    }
		}
		if(results.isEmpty()) {
			System.out.println("Not Found");
		}
		else {
			System.out.println("Done");
		}
    }
	
	public void deleteFirstN(int n){
		//11. remove first n nodes
		if(n>lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		else {
			System.out.println("Done");
		}
		for(int i=0; i<n; i++) {
			lst.remove(0);
		}
    }	
	
	public void deleteAll(){
		lst = new LinkedList<Keyword>();
		System.out.println("Done");
	}
		
		private void printKeywordList(LinkedList<Keyword> kLst){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<kLst.size();i++){
				Keyword k= kLst.get(i);
				if(i>0)sb.append(" ");
				sb.append(k.toString());
			}
			System.out.println(sb.toString());
		}
	}

