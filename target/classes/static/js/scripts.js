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
            var formData = new FormData();
            formData.append(this.contato.nome, this.contato.email);
            axios.post('http://localhost:8080/adicionarcontato', formData).then(response => {
                console.log(response.data)
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