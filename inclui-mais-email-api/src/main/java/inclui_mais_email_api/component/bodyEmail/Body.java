package inclui_mais_email_api.component.bodyEmail;

public enum Body {
    NEW_USER(
        """
       Olá, <br><br>
       Esperamos que esta mensagem o encontre bem. 
       Gostaríamos de expressar nossa sincera gratidão pelo seu recente cadastro em nossa newsletter. 
       É um prazer tê-lo(a) conosco!<br>
       Ao se inscrever, você está prestes a receber informações exclusivas, atualizações emocionantes e 
       conteúdos relevantes diretamente em sua caixa de entrada. Estamos empolgados em compartilhar as últimas novidades, 
       dicas úteis e ofertas especiais que certamente agregarão valor à sua experiência.
       <br>Acreditamos que a comunicação é a chave para construir uma relação sólida, e estamos comprometidos em fornecer 
       conteúdo interessante e informativo que atenda às suas expectativas. Se houver temas específicos que você gostaria 
       de ver abordados ou se tiver algum feedback para compartilhar, não hesite em nos informar. Sua opinião é valiosa para nós.<br>
       Fique à vontade para explorar nosso site e descobrir mais sobre os produtos/serviços que oferecemos. Caso tenha alguma dúvida ou 
       precise de assistência, nossa equipe de suporte está sempre pronta para ajudar.<br>
       Agradecemos mais uma vez por escolher se juntar à nossa comunidade através da assinatura de nossa newsletter. 
       Estamos ansiosos para manter uma conexão significativa e enriquecedora.<br><br>
       Seja bem-vindo(a)!
       """);

    Body(String content) {

    }

    public static String toString(Body type) {
        return String.valueOf(type);
    }
}
