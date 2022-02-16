import React from 'react'
import { Switch, Route } from 'react-router-dom'

import Home from '../pages/Home'
import Game from '../contents/Game'
import Credit from '../contents/Credit'

export default () => (
<Switch>
    <Route exact path="/" component={Home} />
    <Route exact path="/game" component={Game} />
    <Route exact path="/credit" component={Credit} />
</Switch>
)