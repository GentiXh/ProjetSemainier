public class RegimeAlimentaire {
	//Je pense que l'appel avec les ppt omnivores,... venant de SQL se fera ici I think
	
    public RegimeAlimentaire (String omnivore,String vegetarien,String vegan) {
        this.omnivore = omnivore;
        this.vegetarien = vegetarien;
        this.vegan = vegan;
    }
    
    public String  {
        return " .... sérieux ... comment vous décrivez des glapissements vous ???";
    }
    
    public String toString() {
        return super.toString()+" et j’avance à pas feutrés";
    }
}

//Lorsque l'on appuie sur bouton Omnivore 0 ou Vegetarien 1 ou Vegan 2; cela enregistre the number et à partir du number enregistré 
//il faut acceder à la base de donnée idIngredient que l'on regarde quels ingrédients correspondent niveau boolean au regime
//spécifié puis qu'on les enregistre dans les linked List  
