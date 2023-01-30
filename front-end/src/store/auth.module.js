import AuthService from '../services/auth.service';

//  로컬스토리지에서 저장된 user 객체 가져오기
const user = JSON.parse(localStorage.getItem('user'));
// user가 있으면 
//        initialState( == state) = { status: { loggedIn: true }, user }
// user가 없으면
//        initialState( == state) = { status: { loggedIn: false }, user: null }
const initialState = user
  ? { status: { loggedIn: true }, user }
  : { status: { loggedIn: false }, user: null };

export const auth = {
  namespaced: true,
  state: initialState,
  actions: {
    login({ commit }, user) {                                                                                                                                                                                                                                                                  
      return AuthService.login(user)
      .then(
        user => {
          commit('loginSuccess', user);
          return Promise.resolve(user);
        }
      )
      .catch(
        error => {
          commit('loginFailure');
          return Promise.reject(error);
        }
      )
    },
    logout({ commit }) {
      AuthService.logout();
      commit('logout');
    },
    register({ commit }, user) {
      return AuthService.register(user)
      .then(
        response => {
          commit('registerSuccess');
          return Promise.resolve(response.data);
        },
      )
      .catch(
        error => {
          commit('registerFailure');
          return Promise.reject(error);
        }
      )
    }
  },
  mutations: {
    loginSuccess(state, user) {
      state.status.loggedIn = true;
      state.user = user;
    },
    loginFailure(state) {
      state.status.loggedIn = false;
      state.user = null;
    },
    logout(state) {
      state.status.loggedIn = false;
      state.user = null;
    },
    registerSuccess(state) {
      state.status.loggedIn = false;
    },
    registerFailure(state) {
      state.status.loggedIn = false;
    }
  }
};
