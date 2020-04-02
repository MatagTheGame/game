import React from 'react'
import {connect} from 'react-redux'
import get from 'lodash/get'
import Card from '../Card/Card'
import PropTypes from 'prop-types'
import StackUtils from './StackUtils'
import {TriggeredAbility} from './TriggeredAbility'
import './stack.scss'

function Stack(props) {
  const renderStackItem = (cardInstance, i) => {
    const style = {transform: 'translateY(-150px) translateX(' + (i * 50) + 'px) translateZ(' + (i * 150) + 'px)'}
    if (StackUtils.isACastedCard(cardInstance)) {
      return (
        <span key={cardInstance.id} style={style}>
          <Card cardInstance={cardInstance} area='stack'/>
        </span>
      )

    } else {
      return (
        <span key={cardInstance.id} style={style}>
          <TriggeredAbility cardInstance={cardInstance} />
        </span>
      )
    }
  }

  const renderStack = () => {
    return props.stack.map((cardInstance, index) => renderStackItem(cardInstance, index))
  }

  return (
    <div id='stack'>
      {renderStack()}
    </div>
  )
}

const mapStateToProps = state => {
  return {
    stack: get(state, 'stack', [])
  }
}

Stack.propTypes = {
  stack: PropTypes.array.isRequired
}

export default connect(mapStateToProps)(Stack)