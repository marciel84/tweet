import React, { Component } from 'react';
import './css/side-menu.css';
import './css/side-menu-old-ie.css';
import $ from 'jquery';

class App extends Component {

  constructor() {
    super();    
    this.state = {lista : [], listaTweets : [], listaLang : []};
  }

  componentDidMount(){
    $.get({
        url:"http://localhost:8080/twitter/users",
        dataType: 'json',
        success:function(request){            
          this.setState({lista:request});
        }.bind(this)
      } 
    ); 
    
    $.get({
        url:"http://localhost:8080/twitter/tweets",
        dataType: 'json',
        success:function(request){             
          this.setState({listaTweets:request});
        }.bind(this)
      } 
    );

    $.get({
        url:"http://localhost:8080/twitter/hashTags",
        dataType: 'json',
        success:function(request){             
          this.setState({listaLang:request});
        }.bind(this)
      } 
    );

  }

  render() {
    return (
      <div id="layout">
        <a href="#menu" id="menuLink" className="menu-link">
            <span></span>
        </a>

        <div id="menu">
            <div className="pure-menu">
                <ul className="pure-menu-list">
                    <li className="pure-menu-item"><a href="#" className="pure-menu-link">Home</a></li>
                </ul>
            </div>
        </div>

        <div id="main">
            <div className="header">
                <h1>Twitter</h1>
                <h2>Chamada de Apis</h2>
            </div>

            <div className="content">
                <h2 className="content-subhead">Top 5 - Maiores seguidores</h2>
                <div>            
                      <table className="pure-table">
                        <thead>
                          <tr>
                            <th width="250px">Nome</th>
                            <th >Seguidores</th>
                          </tr>
                        </thead>
                        <tbody>
                          {
                            this.state.lista.map(function(user){
                              return (
                                <tr key={user.id}>
                                  <td>{user.name}</td>
                                  <td>{user.followersCount}</td>
                                </tr>
                              );
                            })
                          }
                        </tbody>
                      </table> 
                  </div>

                <h2 className="content-subhead">Total de postagens por hora</h2>
                <div>            
                      <table className="pure-table">
                        <thead>
                          <tr>
                            <th width="250px">Data</th>
                            <th >Postagens</th>
                          </tr>
                        </thead>
                        <tbody>
                          {
                            this.state.listaTweets.map(function(tweet){
                              return (
                                <tr key={tweet.id}>
                                  <td>{tweet.dataHora}</td>
                                  <td>{tweet.total}</td>
                                </tr>
                              );
                            })
                          }
                        </tbody>
                      </table> 
                  </div>

                <h2 className="content-subhead">Total de postagens por Idioma</h2>
                <div>            
                      <table className="pure-table">
                        <thead>
                          <tr>
                            <th width="250px">HashTag</th>
                            <th >Total</th>
                            <th >Idioma</th>
                          </tr>
                        </thead>
                        <tbody>
                          {
                            this.state.listaLang.map(function(idioma){
                              return (
                                <tr key={idioma.id}>
                                  <td>{idioma.hashTag}</td>
                                  <td>{idioma.total}</td>
                                  <td>{idioma.lang }</td>
                                </tr>
                              );
                            })
                          }
                        </tbody>
                      </table> 
                  </div>
            </div>
        </div>
      </div>
    );
  }
}

export default App;
