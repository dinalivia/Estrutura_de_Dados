class ListaCandidatos {
public:
    NoCandidato *head;
    int size;

    bool estaVazia(){
        return head==NULL;
    }

    ListaCandidatos(){
        this->head=NULL;
	this->size=0;
    }
    int tamanho(){
    	return this->size;
    }
    void adicioneComoHead(Candidato *c){
	 NoCandidato* m = NULL;
	 m = new NoCandidato(c,NULL);
         this->head=m;
         this->head->next=head;
         this->size=size+1;
    }

}
