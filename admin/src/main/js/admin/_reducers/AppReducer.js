const clone = (object) => {
  if (!object) {
    object = {}
  }
  return JSON.parse(JSON.stringify(object))
}

export default (state, action) => {
  const newState = clone(state)

  if (!state) {
    if (sessionStorage.key('token')) {
      return {session: {token: sessionStorage.getItem('token')}}
    } else {
      return {}
    }

  } else if (action.type === 'LOAD_STATS') {
    newState.stats = {loading: true}

  } else if (action.type === 'STATS_LOADED') {
    newState.stats.loading = false
    newState.stats.value = action.value

  } else if (action.type === 'LOGIN_LOADING') {
    newState.login = {loading: true}

  } else if (action.type === 'LOGIN_RESPONSE') {
    newState.login = {loading: false}
    if (action.value.error) {
      newState.login.error = action.value.error
    } else {
      sessionStorage.setItem('token', action.value.token)
      newState.session = {token: action.value.token}
    }

  } else {
    throw new Error(`Unknown action type ${action.type}`)
  }

  return newState
}