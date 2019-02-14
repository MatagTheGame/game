import React, {PureComponent} from 'react';
import {connect} from 'react-redux'
import Card from '../Card'

class PlayerLibrary extends PureComponent {
  render() {
    return (
      <div id="player-library">
        {this.props.cards.length > 0 ? <Card name={'card'} /> : null}
      </div>
    )
  }
}

const mapStateToProps = state => {
  return {
    cards: state.player.library.cards
  }
}

const mapDispatchToProps = dispatch => {
  return {
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(PlayerLibrary)