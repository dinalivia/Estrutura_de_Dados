#include "Candidato.h"


class NoCandidato
{
public:
	Candidato *conteudo;
    NoCandidato *next;

	NoCandidato();

	NoCandidato(Candidato *c,NoCandidato *prox){
		this->conteudo=c;
    	this->next=prox;
    }

    ~NoCandidato();

    string toString(){
	   //return conteudo->toString();	
	// se a recursiva for aqui mesmo	
      if(!(this==NULL)){
  	  	return this->conteudo->toString()+ " -> " +  this->next->toString();
  	  }
  	  else
		return "0";
	}

};
