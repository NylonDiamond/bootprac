const app = new Vue({
    el: "#app",

    data: {//object full of objects example
        Jesse:{
          firstName: "jesse",
          lastName: "skelton",
            age: 27
        },
        Bobby: {
            firstName: "bobby",
            lastName: "shelly",
            age: 43
        }
    },
    computed: {
      dataFullName(){ // no value passed in
          return `${this.firstName} ${this.lastName}`
      }
    },

    filters: { // same as above but does anything thats passed in, useful for multiple people
        fullName(value){
            return `${value.firstName} ${value.lastName}`
        },
        agePlusOneYear(value){
            return `${value.age + 1}`
        }
    },

    template: `
            <div>
                <!--original way-->
                <!--<H1>HI {{Jesse.name}}</H1>-->
                <!--computed way-->
                <!--<H1>HI {{Jesse.dataFullName}}</H1>-->
                <!--pipe data through a function-->
                <H1>HI {{Jesse | fullName}}</H1>
                <H1>You're {{Jesse.age}} years old!</H1>
                <H1>You'll be {{Jesse | agePlusOneYear}} next year!</H1>
            </div>`
});