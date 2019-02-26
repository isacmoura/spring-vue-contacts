new Vue({
    el: '#contato',
    data() {
        return {
            contatos: []
        }
    },

    methods: {
        getContatos() {
            axios.get('http://localhost:8080/listar').then(response => {
                this.contatos = response.data
            }).catch(error => {
                console.log(error)
            })
        }
    },

    mounted() {
        this.getContatos();
    },
});