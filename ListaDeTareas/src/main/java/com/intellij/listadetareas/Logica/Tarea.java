public class Tarea{
    private String name;
    private String description;
    private String date;
    private boolean status;
    public Tarea(){
    }
    public Tarea(String name, String description, String date, boolean status){
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDate(){
        return this.date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(Boolean status){
        this.status=status;
    }
    @Override
    public String toString(){
        String p = this.status? "Pendiente": "Realizado";
        return "Name: "+ this.name +"\n"+ 
                "Description: "+this.description +"\n"+ 
                "Fecha: " + this.date +"\n"+ 
                "Estado: " + p +"\n";
    }
}