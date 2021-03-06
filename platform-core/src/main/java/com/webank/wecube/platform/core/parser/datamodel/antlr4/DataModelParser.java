// Generated from /Users/howechen/GitHub/wecube-platform/platform-core/src/main/resources/DataModel.g4 by ANTLR 4.7.2
package com.webank.wecube.platform.core.parser.datamodel.antlr4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DataModelParser extends Parser {
    public static final int
            TILDE = 1, GT = 2, DOT = 3, LP = 4, RP = 5, DC = 6, SC = 7, DQM = 8, ID = 9, PKG_ID = 10,
            WS = 11;
    public static final int
            RULE_route = 0, RULE_link = 1, RULE_fetch = 2, RULE_to = 3, RULE_by = 4,
            RULE_fwd_node = 5, RULE_bwd_node = 6, RULE_entity = 7, RULE_pkg = 8, RULE_ety = 9,
            RULE_attr = 10;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rT\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4" +
                    "\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\5\2\37\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\3\3\3\3\5\3*\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\65\n\3\f\3\16" +
                    "\38\13\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3" +
                    "\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\2\3\4\r\2\4\6\b\n\f\16" +
                    "\20\22\24\26\2\3\3\2\n\13\2L\2\36\3\2\2\2\4)\3\2\2\2\69\3\2\2\2\b<\3\2" +
                    "\2\2\n>\3\2\2\2\f@\3\2\2\2\16D\3\2\2\2\20I\3\2\2\2\22M\3\2\2\2\24O\3\2" +
                    "\2\2\26Q\3\2\2\2\30\31\5\4\3\2\31\32\5\6\4\2\32\37\3\2\2\2\33\34\5\20" +
                    "\t\2\34\35\5\6\4\2\35\37\3\2\2\2\36\30\3\2\2\2\36\33\3\2\2\2\37\3\3\2" +
                    "\2\2 !\b\3\1\2!\"\5\20\t\2\"#\5\n\6\2#$\5\16\b\2$*\3\2\2\2%&\5\f\7\2&" +
                    "\'\5\b\5\2\'(\5\20\t\2(*\3\2\2\2) \3\2\2\2)%\3\2\2\2*\66\3\2\2\2+,\f\4" +
                    "\2\2,-\5\6\4\2-.\5\b\5\2./\5\20\t\2/\65\3\2\2\2\60\61\f\3\2\2\61\62\5" +
                    "\n\6\2\62\63\5\16\b\2\63\65\3\2\2\2\64+\3\2\2\2\64\60\3\2\2\2\658\3\2" +
                    "\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\5\3\2\2\28\66\3\2\2\29:\7\5\2\2:;" +
                    "\5\26\f\2;\7\3\2\2\2<=\7\4\2\2=\t\3\2\2\2>?\7\3\2\2?\13\3\2\2\2@A\5\20" +
                    "\t\2AB\7\5\2\2BC\5\26\f\2C\r\3\2\2\2DE\7\6\2\2EF\5\26\f\2FG\7\7\2\2GH" +
                    "\5\20\t\2H\17\3\2\2\2IJ\5\22\n\2JK\7\t\2\2KL\5\24\13\2L\21\3\2\2\2MN\t" +
                    "\2\2\2N\23\3\2\2\2OP\7\13\2\2P\25\3\2\2\2QR\7\13\2\2R\27\3\2\2\2\6\36" +
                    ")\64\66";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public DataModelParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "route", "link", "fetch", "to", "by", "fwd_node", "bwd_node", "entity",
                "pkg", "ety", "attr"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'~'", "'>'", "'.'", "'('", "')'", null, "':'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "TILDE", "GT", "DOT", "LP", "RP", "DC", "SC", "DQM", "ID", "PKG_ID",
                "WS"
        };
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "DataModel.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final RouteContext route() throws RecognitionException {
        RouteContext _localctx = new RouteContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_route);
        try {
            setState(28);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(22);
                    link(0);
                    setState(23);
                    fetch();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(25);
                    entity();
                    setState(26);
                    fetch();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LinkContext link() throws RecognitionException {
        return link(0);
    }

    private LinkContext link(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        LinkContext _localctx = new LinkContext(_ctx, _parentState);
        LinkContext _prevctx = _localctx;
        int _startState = 2;
        enterRecursionRule(_localctx, 2, RULE_link, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(39);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                    case 1: {
                        setState(31);
                        entity();
                        setState(32);
                        by();
                        setState(33);
                        bwd_node();
                    }
                    break;
                    case 2: {
                        setState(35);
                        fwd_node();
                        setState(36);
                        to();
                        setState(37);
                        entity();
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(52);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(50);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                                case 1: {
                                    _localctx = new LinkContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_link);
                                    setState(41);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(42);
                                    fetch();
                                    setState(43);
                                    to();
                                    setState(44);
                                    entity();
                                }
                                break;
                                case 2: {
                                    _localctx = new LinkContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_link);
                                    setState(46);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(47);
                                    by();
                                    setState(48);
                                    bwd_node();
                                }
                                break;
                            }
                        }
                    }
                    setState(54);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final FetchContext fetch() throws RecognitionException {
        FetchContext _localctx = new FetchContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_fetch);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(55);
                match(DOT);
                setState(56);
                attr();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ToContext to() throws RecognitionException {
        ToContext _localctx = new ToContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_to);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(58);
                match(GT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ByContext by() throws RecognitionException {
        ByContext _localctx = new ByContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_by);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(60);
                match(TILDE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Fwd_nodeContext fwd_node() throws RecognitionException {
        Fwd_nodeContext _localctx = new Fwd_nodeContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_fwd_node);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(62);
                entity();
                setState(63);
                match(DOT);
                setState(64);
                attr();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Bwd_nodeContext bwd_node() throws RecognitionException {
        Bwd_nodeContext _localctx = new Bwd_nodeContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_bwd_node);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(66);
                match(LP);
                setState(67);
                attr();
                setState(68);
                match(RP);
                setState(69);
                entity();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EntityContext entity() throws RecognitionException {
        EntityContext _localctx = new EntityContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_entity);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(71);
                pkg();
                setState(72);
                match(SC);
                setState(73);
                ety();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PkgContext pkg() throws RecognitionException {
        PkgContext _localctx = new PkgContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_pkg);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(75);
                _la = _input.LA(1);
                if (!(_la == DQM || _la == ID)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EtyContext ety() throws RecognitionException {
        EtyContext _localctx = new EtyContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_ety);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(77);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AttrContext attr() throws RecognitionException {
        AttrContext _localctx = new AttrContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_attr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(79);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 1:
                return link_sempred((LinkContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean link_sempred(LinkContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 2);
            case 1:
                return precpred(_ctx, 1);
        }
        return true;
    }

    public static class RouteContext extends ParserRuleContext {
        public RouteContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public LinkContext link() {
            return getRuleContext(LinkContext.class, 0);
        }

        public FetchContext fetch() {
            return getRuleContext(FetchContext.class, 0);
        }

        public EntityContext entity() {
            return getRuleContext(EntityContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_route;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterRoute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitRoute(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitRoute(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LinkContext extends ParserRuleContext {
        public LinkContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public EntityContext entity() {
            return getRuleContext(EntityContext.class, 0);
        }

        public ByContext by() {
            return getRuleContext(ByContext.class, 0);
        }

        public Bwd_nodeContext bwd_node() {
            return getRuleContext(Bwd_nodeContext.class, 0);
        }

        public Fwd_nodeContext fwd_node() {
            return getRuleContext(Fwd_nodeContext.class, 0);
        }

        public ToContext to() {
            return getRuleContext(ToContext.class, 0);
        }

        public LinkContext link() {
            return getRuleContext(LinkContext.class, 0);
        }

        public FetchContext fetch() {
            return getRuleContext(FetchContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_link;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterLink(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitLink(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitLink(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FetchContext extends ParserRuleContext {
        public FetchContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DOT() {
            return getToken(DataModelParser.DOT, 0);
        }

        public AttrContext attr() {
            return getRuleContext(AttrContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fetch;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterFetch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitFetch(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitFetch(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ToContext extends ParserRuleContext {
        public ToContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GT() {
            return getToken(DataModelParser.GT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_to;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterTo(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitTo(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitTo(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ByContext extends ParserRuleContext {
        public ByContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TILDE() {
            return getToken(DataModelParser.TILDE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_by;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterBy(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitBy(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitBy(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Fwd_nodeContext extends ParserRuleContext {
        public Fwd_nodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public EntityContext entity() {
            return getRuleContext(EntityContext.class, 0);
        }

        public TerminalNode DOT() {
            return getToken(DataModelParser.DOT, 0);
        }

        public AttrContext attr() {
            return getRuleContext(AttrContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fwd_node;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterFwd_node(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitFwd_node(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor)
                return ((DataModelVisitor<? extends T>) visitor).visitFwd_node(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Bwd_nodeContext extends ParserRuleContext {
        public Bwd_nodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LP() {
            return getToken(DataModelParser.LP, 0);
        }

        public AttrContext attr() {
            return getRuleContext(AttrContext.class, 0);
        }

        public TerminalNode RP() {
            return getToken(DataModelParser.RP, 0);
        }

        public EntityContext entity() {
            return getRuleContext(EntityContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bwd_node;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterBwd_node(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitBwd_node(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor)
                return ((DataModelVisitor<? extends T>) visitor).visitBwd_node(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EntityContext extends ParserRuleContext {
        public EntityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PkgContext pkg() {
            return getRuleContext(PkgContext.class, 0);
        }

        public TerminalNode SC() {
            return getToken(DataModelParser.SC, 0);
        }

        public EtyContext ety() {
            return getRuleContext(EtyContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_entity;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterEntity(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitEntity(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitEntity(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PkgContext extends ParserRuleContext {
        public PkgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(DataModelParser.ID, 0);
        }

        public TerminalNode DQM() {
            return getToken(DataModelParser.DQM, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pkg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterPkg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitPkg(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitPkg(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EtyContext extends ParserRuleContext {
        public EtyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(DataModelParser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ety;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterEty(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitEty(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitEty(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AttrContext extends ParserRuleContext {
        public AttrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(DataModelParser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).enterAttr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DataModelListener) ((DataModelListener) listener).exitAttr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DataModelVisitor) return ((DataModelVisitor<? extends T>) visitor).visitAttr(this);
            else return visitor.visitChildren(this);
        }
    }
}