import {createRouter, createWebHistory} from "vue-router";

const routes = [
    {
        path: '/',
        name: 'index',
        component: () => import("../views/index.vue"),
        children: [
            {
                path: '/user_behavior',
                name: 'user_behavior',
                component: () => import("../views/user_behavior.vue")
            },
            {
                path: '/user_behavior_date',
                name: 'user_behavior_date',
                component: () => import("../views/user_behavior_date.vue")
            },
            {
                path: '/charger_time',
                name: 'charger_time',
                component: () => import("../views/charger_time.vue")
            },
            {
                path: '/charge_week_hour_time',
                name: 'charger_week_hour_time',
                component: () => import("../views/chargerWeekTime.vue")
            }
        ]
    },

]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
