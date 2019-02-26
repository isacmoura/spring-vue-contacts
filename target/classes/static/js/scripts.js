new Vue({
    el: '#app',
    data: {
        contatos: [],
        contato: {
            nome: '',
            email: ''
        }
    },

    methods: {
        getContatos() {
            axios.get('http://localhost:8080/listar').then(response => {
                this.contatos = response.data
            }).catch(error => {
                console.log(error)
            })
        },

        onSubmit() {
            axios.post('http://localhost:8080/adicionarcontato', {
                nome: this.contato.nome,
                email: this.contato.email
            }).then(response => {
                this.contato.nome = response.data.nome
                this.contato.email = response.data.email
            }).catch(error => {
                console.log(error)
            })
        }
    },

    mounted() {
        this.getContatos();
        this.onSubmit();
    },
});

new Vue({

})