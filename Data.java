public class Data implements java.io.Serializable{
   int id;
   String name;
   boolean bool;
 
  public Data(int id, String name, boolean bool){
    this.id=id;
    this.name=name;
    this.bool=bool;
  }

  public int getid(){
    return id;
  }

  public String getname(){
    return name;
  }

  public Boolean getbool(){
    return bool;
  }

  public void setid(int id){
    this.id = id;
  }

  public void setname(String name){
    this.name = name;
  }

  public void setbool(Boolean bool){
    this.bool = bool;
  }

  public String toString(){
    return "<"+name+","+id+","+bool+">";
  }
}