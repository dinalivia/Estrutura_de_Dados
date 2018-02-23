#include "Candidato.h"

class NoCandidato{
    public:
        Candidato *conteudo;
        NoCandidato *next;

        NoCandidato(Candidato *c, NoCandidato *prox){
            this ->conteudo = c;
            this ->next = prox;
        }

        string toString(){
            return conteudo->toString();
            // implementar pra exibir todos os nos,
            //por um laco de repeticao ou recursao
        }
};
