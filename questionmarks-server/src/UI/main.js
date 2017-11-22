Vue.component('friend-component', {
    props: ['friend'],// expecting a friend object to be passed into this component

    filters: { // same as above but does anything thats passed in, useful for multiple people
        fullName(value) {
            return `${value.firstName} ${value.lastName}`
        },
        agePlusOneYear(value) {
            return `${value.age + 1}`
        }
    },
    methods: { // methods
        addOne(friend) {
            friend.age += 1;
        },
        subtractOne(friend) {
            friend.age -= 1;
        }
    },
    template: `
            <div>       
                <h4>{{friend | fullName}}</h4>
                <h5>{{friend.age}}</h5>
                <!--two way data binding-->
                <input v-model="friend.firstName"/>
                <input v-model="friend.lastName"/>
                <button v-on:click="addOne(friend)">Increase Age +1</button>
                <button v-on:click="subtractOne(friend)">Increase Age +1</button>
            </div>`
});


const app = new Vue({
    el: "#app",

    data: {
        friends: [
            {
                firstName: "jesse",
                lastName: "skelton",
                age: 27
            },
            {
                firstName: "bobby",
                lastName: "shelly",
                age: 43
            }
        ]
    },

    template: `
            <div>
            <!--for loop-->
            <!--Take the friend object and pass it into this component 'v-bind:friend'-->
               <friend-component v-for="friend in friends" v-bind:friend="friend"/>             
            </div>`
});