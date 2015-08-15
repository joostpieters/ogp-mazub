package jumpingalien.model.programs;

import jumpingalien.model.programs.expressions.equation.*;
import jumpingalien.model.programs.expressions.logical.AndExpr;
import jumpingalien.model.programs.expressions.logical.NotExpr;
import jumpingalien.model.programs.expressions.logical.OrExpr;
import jumpingalien.model.programs.expressions.data.BoolExpr;
import jumpingalien.model.programs.expressions.data.DirectionConstExpr;
import jumpingalien.model.programs.expressions.data.DoubleConstExpr;
import jumpingalien.model.programs.expressions.data.NullExpr;
import jumpingalien.model.programs.expressions.operator.AdditionExpr;
import jumpingalien.model.programs.expressions.operator.DivisonExpr;
import jumpingalien.model.programs.expressions.operator.MultiplicationExpr;
import jumpingalien.model.programs.expressions.operator.SubtractionExpr;
import jumpingalien.model.programs.expressions.recursive.RandomExpr;
import jumpingalien.model.programs.expressions.recursive.SquareRootExpr;
import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

import java.util.List;
import java.util.Map;

/**
 * Created by covert on 14/08/15.
 */
public class Factory implements IProgramFactory<Expression, Statement, Type, Program> {

    /**
     * An expression that evaluates to the value of the variable with the given
     * name and declared type
     *
     * @param variableName
     * @param variableType
     * @param sourceLocation
     */
    @Override
    public Expression createReadVariable(String variableName, Type variableType, SourceLocation sourceLocation) {
        return new Expression() {
            @Override
            public Object getValue() {
                return getSourceLocation(); //TODO
            }
        };
    }

    /**
     * An expression that evaluates to the given numeric value
     *
     * @param value
     * @param sourceLocation
     */
    @Override
    public Expression createDoubleConstant(double value, SourceLocation sourceLocation) {
        return new DoubleConstExpr(sourceLocation,value);
    }

    /**
     * An expression that evaluates to true
     *
     * @param sourceLocation
     */
    @Override
    public Expression createTrue(SourceLocation sourceLocation) {
        return new BoolExpr(sourceLocation,true);
    }

    /**
     * An expression that evaluates to false
     *
     * @param sourceLocation
     */
    @Override
    public Expression createFalse(SourceLocation sourceLocation) {
        return new BoolExpr(sourceLocation,true);
    }

    /**
     * An expression that evaluates to null
     *
     * @param sourceLocation
     */
    @Override
    public Expression createNull(SourceLocation sourceLocation) {
        return new NullExpr(sourceLocation);
    }

    /**
     * An expression that evaluates to the game object that is executing the
     * programs
     *
     * @param sourceLocation
     */
    @Override
    public Expression createSelf(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the given direction
     *
     * @param value
     * @param sourceLocation
     */
    @Override
    public Expression createDirectionConstant(Direction value, SourceLocation sourceLocation) {
        return new DirectionConstExpr(sourceLocation,value);
    }

    /**
     * An expression that evaluates to the sum of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createAddition(Expression left, Expression right, SourceLocation sourceLocation) {
        return new AdditionExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to the difference of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createSubtraction(Expression left, Expression right, SourceLocation sourceLocation) {
        return new SubtractionExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to the product of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createMultiplication(Expression left, Expression right, SourceLocation sourceLocation) {
        return new MultiplicationExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to the division of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createDivision(Expression left, Expression right, SourceLocation sourceLocation) {
        return new DivisonExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to the square root of the given expressions
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createSqrt(Expression expr, SourceLocation sourceLocation) {
        return new SquareRootExpr(sourceLocation,expr);
    }

    /**
     * An expression that evaluates to a random value between 0 (inclusive) and
     * the given maximum value (exclusive)
     *
     * @param maxValue
     * @param sourceLocation
     */
    @Override
    public Expression createRandom(Expression maxValue, SourceLocation sourceLocation) {
        return new RandomExpr(sourceLocation,maxValue);
    }

    /**
     * An expression that evaluates to the conjunction of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createAnd(Expression left, Expression right, SourceLocation sourceLocation) {
        return new AndExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to the disjunction of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createOr(Expression left, Expression right, SourceLocation sourceLocation) {
        return new OrExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to the negation of the given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createNot(Expression expr, SourceLocation sourceLocation) {
        return new NotExpr(sourceLocation,expr);
    }

    /**
     * An expression that evaluates to true if the value of the left expression
     * is less than the value of the right expression
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createLessThan(Expression left, Expression right, SourceLocation sourceLocation) {
        return new LessThanExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to true if the value of the left expression
     * is less than or equal to the value of the right expression
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createLessThanOrEqualTo(Expression left, Expression right, SourceLocation sourceLocation) {
        return new LessOrEqualExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to true if the value of the left expression
     * is greater than the value of the right expression
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createGreaterThan(Expression left, Expression right, SourceLocation sourceLocation) {
        return new GreaterThanExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to true if the value of the left expression
     * is greater than or equal to the value of the right expression
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createGreaterThanOrEqualTo(Expression left, Expression right, SourceLocation sourceLocation) {
        return new GreaterOrEqualExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to true if the value of the left expression
     * equals the value of the right expression
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createEquals(Expression left, Expression right, SourceLocation sourceLocation) {
        return new EqualExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to true if the value of the left expression
     * does not equal the value of the right expression
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Expression createNotEquals(Expression left, Expression right, SourceLocation sourceLocation) {
        return new NotEqualExpr(sourceLocation,left,right);
    }

    /**
     * An expression that evaluates to the x-value of the object obtained from
     * the given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createGetX(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the y-value of the object obtained from
     * the given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createGetY(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the width of the object obtained from the
     * given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createGetWidth(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the height of the object obtained from
     * the given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createGetHeight(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the number of hitpoints of the object
     * obtained from the given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createGetHitPoints(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the tile in which the pixel with
     * coordinates (x, y) lies.
     *
     * @param x
     * @param y
     * @param sourceLocation
     */
    @Override
    public Expression createGetTile(Expression x, Expression y, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the first object that is encountered in
     * the given direction
     *
     * @param direction
     * @param sourceLocation
     */
    @Override
    public Expression createSearchObject(Expression direction, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is a Mazub
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsMazub(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is a Shark
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsShark(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is a Slime
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsSlime(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is a Plant
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsPlant(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is dead
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsDead(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is part of the terrain
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsTerrain(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is passable
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsPassable(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is water
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsWater(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is magma
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsMagma(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is air
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsAir(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is moving
     *
     * @param expr
     * @param direction
     * @param sourceLocation
     */
    @Override
    public Expression createIsMoving(Expression expr, Expression direction, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is ducking
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsDucking(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true if the object obtained from the
     * given expression is jumping
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Expression createIsJumping(Expression expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that changes the value of the variable with the given name
     * and declared type to the value obtained from the given expression
     *
     * @param variableName
     * @param variableType
     * @param value
     * @param sourceLocation
     */
    @Override
    public Statement createAssignment(String variableName, Type variableType, Expression value, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that executes the given body while the given condition
     * evaluates to true
     *
     * @param condition
     * @param body
     * @param sourceLocation
     */
    @Override
    public Statement createWhile(Expression condition, Statement body, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that executes the given body with the given variable set to
     * all objects of the given kind for which the where-expression evaluates to
     * true, sorted by the result of the given sort expression in the given
     * direction. The where- and sort-expressions are optional, and can be null;
     *
     * @param variableName
     * @param variableKind
     * @param where
     * @param sort
     * @param sortDirection
     * @param body
     * @param sourceLocation
     */
    @Override
    public Statement createForEach(String variableName, Kind variableKind, Expression where, Expression sort, SortDirection sortDirection, Statement body, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that terminates the currently executing loop
     *
     * @param sourceLocation
     */
    @Override
    public Statement createBreak(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that executes the given ifBody if the condition evaluates to
     * true, and the given elseBody otherwise.
     * The elseBody is optional, and can be null.
     *
     * @param condition
     * @param ifBody
     * @param elseBody
     * @param sourceLocation
     */
    @Override
    public Statement createIf(Expression condition, Statement ifBody, Statement elseBody, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that prints the value of the given expression
     *
     * @param value
     * @param sourceLocation
     */
    @Override
    public Statement createPrint(Expression value, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that makes the object executing the programs start moving in
     * the given direction
     *
     * @param direction
     * @param sourceLocation
     */
    @Override
    public Statement createStartRun(Expression direction, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that makes the object executing the programs stop moving in
     * the given direction
     *
     * @param direction
     * @param sourceLocation
     */
    @Override
    public Statement createStopRun(Expression direction, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that makes the object executing the programs start jumping
     *
     * @param sourceLocation
     */
    @Override
    public Statement createStartJump(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that makes the object executing the programs stop jumping
     *
     * @param sourceLocation
     */
    @Override
    public Statement createStopJump(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that makes the object executing the programs start ducking
     *
     * @param sourceLocation
     */
    @Override
    public Statement createStartDuck(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that makes the object executing the programs stop ducking
     *
     * @param sourceLocation
     */
    @Override
    public Statement createStopDuck(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that suspends the execution of the programs for the given
     * duration
     *
     * @param duration
     * @param sourceLocation
     */
    @Override
    public Statement createWait(Expression duration, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that does nothing
     *
     * @param sourceLocation
     */
    @Override
    public Statement createSkip(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that executes of a list of statements subsequently
     *
     * @param statements
     * @param sourceLocation
     */
    @Override
    public Statement createSequence(List<Statement> statements, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * The type of double values and variables
     */
    @Override
    public Type getDoubleType() {
        return null;
    }

    /**
     * The type of boolean values and variables
     */
    @Override
    public Type getBoolType() {
        return null;
    }

    /**
     * The type of game object values and variables
     */
    @Override
    public Type getGameObjectType() {
        return null;
    }

    /**
     * The type of direction values and variables
     */
    @Override
    public Type getDirectionType() {
        return null;
    }

    /**
     * Create a programs with the given main statement and variable declarations.
     * The globalVariables map contains the type for each declared variable,
     * with the name of the variable as the key.
     *
     * @param mainStatement
     * @param globalVariables
     */
    @Override
    public Program createProgram(Statement mainStatement, Map<String, Type> globalVariables) {
        return null;
    }
}
