const clone = (object) => {
  if (!object) {
    object = {}
  }
  return JSON.parse(JSON.stringify(object))
}

export default (state, action) => {
  const newState = clone(state)

  if (!state) {
    return {}

  } else if (action.type === 'LOAD_STATS') {
    newState.stats = {loading: true}

  } else if (action.type === 'STATS_LOADED') {
    newState.stats.loading = false
    newState.stats.value = action.value

  } else if (action.type === 'LOGIN_LOADING') {
    newState.login = {loading: true}

  } else if (action.type === 'LOGIN_ERROR_MESSAGE') {
    newState.login = {loading: false, message: action.value}

  } else {
    throw new Error(`Unknown action type ${action.type}`)
  }

  return newState
}