package jumpingalien.model.programs;

import jumpingalien.part3.programs.IProgramFactory;
import jumpingalien.part3.programs.SourceLocation;

import java.util.List;
import java.util.Map;

/**
 * Created by covert on 14/08/15.
 */
public class Factory implements IProgramFactory<Program, Statement, Expression, Type> {

    /**
     * An expression that evaluates to the value of the variable with the given
     * name and declared type
     *
     * @param variableName
     * @param variableType
     * @param sourceLocation
     */
    @Override
    public Program createReadVariable(String variableName, Expression variableType, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the given numeric value
     *
     * @param value
     * @param sourceLocation
     */
    @Override
    public Program createDoubleConstant(double value, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to true
     *
     * @param sourceLocation
     */
    @Override
    public Program createTrue(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to false
     *
     * @param sourceLocation
     */
    @Override
    public Program createFalse(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to null
     *
     * @param sourceLocation
     */
    @Override
    public Program createNull(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the game object that is executing the
     * programs
     *
     * @param sourceLocation
     */
    @Override
    public Program createSelf(SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the given direction
     *
     * @param value
     * @param sourceLocation
     */
    @Override
    public Program createDirectionConstant(Direction value, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the sum of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Program createAddition(Program left, Program right, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the difference of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Program createSubtraction(Program left, Program right, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the product of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Program createMultiplication(Program left, Program right, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the division of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Program createDivision(Program left, Program right, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the square root of the given expressions
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Program createSqrt(Program expr, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to a random value between 0 (inclusive) and
     * the given maximum value (exclusive)
     *
     * @param maxValue
     * @param sourceLocation
     */
    @Override
    public Program createRandom(Program maxValue, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the conjunction of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Program createAnd(Program left, Program right, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the disjunction of the given expressions
     *
     * @param left
     * @param right
     * @param sourceLocation
     */
    @Override
    public Program createOr(Program left, Program right, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the negation of the given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Program createNot(Program expr, SourceLocation sourceLocation) {
        return null;
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
    public Program createLessThan(Program left, Program right, SourceLocation sourceLocation) {
        return null;
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
    public Program createLessThanOrEqualTo(Program left, Program right, SourceLocation sourceLocation) {
        return null;
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
    public Program createGreaterThan(Program left, Program right, SourceLocation sourceLocation) {
        return null;
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
    public Program createGreaterThanOrEqualTo(Program left, Program right, SourceLocation sourceLocation) {
        return null;
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
    public Program createEquals(Program left, Program right, SourceLocation sourceLocation) {
        return null;
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
    public Program createNotEquals(Program left, Program right, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * An expression that evaluates to the x-value of the object obtained from
     * the given expression
     *
     * @param expr
     * @param sourceLocation
     */
    @Override
    public Program createGetX(Program expr, SourceLocation sourceLocation) {
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
    public Program createGetY(Program expr, SourceLocation sourceLocation) {
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
    public Program createGetWidth(Program expr, SourceLocation sourceLocation) {
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
    public Program createGetHeight(Program expr, SourceLocation sourceLocation) {
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
    public Program createGetHitPoints(Program expr, SourceLocation sourceLocation) {
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
    public Program createGetTile(Program x, Program y, SourceLocation sourceLocation) {
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
    public Program createSearchObject(Program direction, SourceLocation sourceLocation) {
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
    public Program createIsMazub(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsShark(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsSlime(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsPlant(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsDead(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsTerrain(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsPassable(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsWater(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsMagma(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsAir(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsMoving(Program expr, Program direction, SourceLocation sourceLocation) {
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
    public Program createIsDucking(Program expr, SourceLocation sourceLocation) {
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
    public Program createIsJumping(Program expr, SourceLocation sourceLocation) {
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
    public Statement createAssignment(String variableName, Expression variableType, Program value, SourceLocation sourceLocation) {
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
    public Statement createWhile(Program condition, Statement body, SourceLocation sourceLocation) {
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
    public Statement createForEach(String variableName, Kind variableKind, Program where, Program sort, SortDirection sortDirection, Statement body, SourceLocation sourceLocation) {
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
    public Statement createIf(Program condition, Statement ifBody, Statement elseBody, SourceLocation sourceLocation) {
        return null;
    }

    /**
     * A statement that prints the value of the given expression
     *
     * @param value
     * @param sourceLocation
     */
    @Override
    public Statement createPrint(Program value, SourceLocation sourceLocation) {
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
    public Statement createStartRun(Program direction, SourceLocation sourceLocation) {
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
    public Statement createStopRun(Program direction, SourceLocation sourceLocation) {
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
    public Statement createWait(Program duration, SourceLocation sourceLocation) {
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
    public Expression getDoubleType() {
        return null;
    }

    /**
     * The type of boolean values and variables
     */
    @Override
    public Expression getBoolType() {
        return null;
    }

    /**
     * The type of game object values and variables
     */
    @Override
    public Expression getGameObjectType() {
        return null;
    }

    /**
     * The type of direction values and variables
     */
    @Override
    public Expression getDirectionType() {
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
    public Type createProgram(Statement mainStatement, Map<String, Expression> globalVariables) {
        return null;
    }
}
